//package com.company;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//
//public class PdfToHtml {
//
//    public static void main(String[] args) {
//        String pdfFilePath = "path_to_your_pdf_file.pdf";
//        String htmlFilePath = "output_file.html";
//
//        try {
//            // Load PDF document
//            PDDocument document = PDDocument.load(new File(pdfFilePath));
//
//            // Extract text from the PDF
//            PDFTextStripper pdfStripper = new PDFTextStripper();
//            String text = pdfStripper.getText(document);
//
//            // Wrap the extracted text in basic HTML structure
//            String htmlContent = "<html><head><title>PDF to HTML</title></head><body>"
//                    + "<pre>" + text + "</pre>"
//                    + "</body></html>";
//
//            // Write the HTML to a file
//            try (FileWriter writer = new FileWriter(htmlFilePath)) {
//                writer.write(htmlContent);
//            }
//
//            // Close the document
//            document.close();
//
//            System.out.println("PDF to HTML conversion completed. HTML file created at: " + htmlFilePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
