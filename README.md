# Class-Practice
#programming practice


package com.optum.dms.pdfprocess.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class PdfProcessController {

    private static final Logger logger = LoggerFactory.getLogger(PdfProcessController.class);

    @Value("${pdf.api.url}")
    private String pdfApiUrl;

    @Value("${pdf.keywords}")
    private String[] keywords;

    @Value("${pdf.output.directory}")
    private String outputDirectory;

    @Value("${process.timeout.seconds}")
    private long processTimeoutSeconds;

    @GetMapping("/process-pdf")
    public ResponseEntity<Map<String, Object>> processPdf(@RequestParam String pdfName) {
        logger.info("Received request to process PDF: {}", pdfName);
        try {
            // Step 1: Consume the PDF from the previous API
            RestTemplate restTemplate = new RestTemplate();
            String pdfUrl = pdfApiUrl + UriUtils.encodePath(pdfName, "UTF-8");;

            logger.info("Fetching PDF from URL: {}", pdfUrl);
            byte[] pdfBytes = restTemplate.getForObject(pdfUrl, byte[].class);

            // Step 2: Save the PDF to a temporary file
            File inputPdf = File.createTempFile("input", ".pdf");
            try (FileOutputStream fos = new FileOutputStream(inputPdf)) {
                fos.write(pdfBytes);
            }
            logger.info("Saved PDF to temporary file: {}", inputPdf.getAbsolutePath());
            // Step 3: Use ocrmypdf to linearize and make the PDF searchable
            File outputPdf = new File(outputDirectory, pdfName);
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "ocrmypdf", "--skip-text","--rotate-pages","--deskew","--jobs", "4", inputPdf.getAbsolutePath(), outputPdf.getAbsolutePath());
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

    private Map<String, Object> extractMetadata(File pdfFile, String[] keywords) throws IOException {
        Map<String, Object> metadata = new HashMap<>();
        try (PDDocument document = PDDocument.load(pdfFile)) {
            PDFTextStripper stripper = new PDFTextStripper();
            for (String keyword : keywords) {
                stripper.setStartPage(1);
                stripper.setEndPage(document.getNumberOfPages());
                String text = stripper.getText(document);
                int pageNumber = 1;
                for (String page : text.split("\\f")) {
                    if (page.contains(keyword)) {
                        List<Integer> pages = (List<Integer>) metadata.getOrDefault(keyword, new ArrayList<>());
                        pages.add(pageNumber);
                        metadata.put(keyword, Map.of(
                                "value", extractValue(page, keyword),
                                "pages", pages
                        ));
                    }
                    pageNumber++;
                }
            }
        }
        return metadata;
    }

    private String extractValue(String page, String keyword) {
        // Dummy implementation for extracting value
        // You can use regex or other text processing techniques to extract the actual value
        int index = page.indexOf(keyword);
        if (index != -1) {
            int startIndex = index + keyword.length();
            int endIndex = page.indexOf("\n", startIndex);
            return page.substring(startIndex, endIndex).trim();
        }
        return "";
    }
}
