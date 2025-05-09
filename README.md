 @GetMapping("/process-pdf-test")
    public ResponseEntity<Map<String, Object>> processPdfTest(@RequestParam String pdfName) {
        logger.info("Received request to process PDF: {}", pdfName);
        try {
            byte[] pdfBytes = new byte[0];
            if(Boolean.parseBoolean(useLocal)){
                File sourceFile = new File(localDirectory,pdfName);
                if(!sourceFile.exists()){
                    logger.error("local pdf not found: {}",sourceFile.getAbsolutePath());
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

                }
                logger.info("loading pdf from local path: {}",sourceFile.getAbsolutePath());
                pdfBytes = Files.readAllBytes(sourceFile.toPath());
            }

            File inputPdf = File.createTempFile("input",".pdf");
            try(FileOutputStream fos = new FileOutputStream(inputPdf)){
                fos.write(pdfBytes);
            }
            logger.info("saved pdf to temporary file:{}",inputPdf.getAbsolutePath());

            File outputPdf = new File(outputDirectory, pdfName);
            String ocrMyPdfCommand = String.format("ocrmypdf --skip-text --rotate-pages --deskew --jobs 4 --output-type pdfa \"%s\" \"%s\"");
//            ProcessBuilder processBuilder = new ProcessBuilder(
//                    "bash","-c",
//                    "ocrmypdf", "--skip-text","--rotate-pages","--deskew","--jobs", "4", inputPdf.getAbsolutePath(), outputPdf.getAbsolutePath()
//            +"&&"+"qpdf","--linearize" + outputPdf.getAbsolutePath() + " " + outputPdf.getAbsolutePath());
            ProcessBuilder processBuilder = new ProcessBuilder("bash","-c",ocrMyPdfCommand,inputPdf.getAbsolutePath(),outputPdf.getAbsolutePath());
            processBuilder.inheritIO();
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            logger.info("Started ocrmypdf process");

            // Capture and log the process output
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    logger.info(line);
                }
            }

            // Step 4: Handle timeout and process completion
            boolean finished = process.waitFor(processTimeoutSeconds, TimeUnit.SECONDS);
            if (!finished) {
                process.destroy();
                logger.error("ocrmypdf process timed out");
                return new ResponseEntity<>(HttpStatus.REQUEST_TIMEOUT);
            }
            if (process.exitValue() != 0) {
                logger.error("ocrmypdf process failed with exit code {}", process.exitValue());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            logger.info("ocrmypdf process completed successfully");
            // Step 5: Extract metadata for given keywords
            Map<String, Object> metadata = extractMetadata(outputPdf, keywords);

            // Step 6: Return the metadata as JSON
            logger.info("Returning metadata for PDF: {}", pdfName);
            return new ResponseEntity<>(metadata, HttpStatus.OK);
        } catch (IOException e) {
            logger.error("Error processing PDF: {}", pdfName, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (InterruptedException e) {
            logger.error("Error processing PDF: {}", pdfName, e);
            return new ResponseEntity<>(HttpStatus.REQUEST_TIMEOUT);
        }
    }


