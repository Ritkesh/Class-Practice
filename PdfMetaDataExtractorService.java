package com.optum.dms.pdfprocess.service;

import com.optum.dms.pdfprocess.entity.Claims;
import com.optum.dms.pdfprocess.entity.PdfMetaData;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j

@Service
public class PdfMetadataExtractorService {
    private static final List<DateTimeFormatter> DATE_FORMATS = List.of(
//            DateTimeFormatter.ofPattern("d/M/yyyy"),  // Added format for single-digit day and month
//            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
//            DateTimeFormatter.ofPattern("MM/dd/yyyy"),
//            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
//            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
//            DateTimeFormatter.ofPattern("dd.MM.yyyy"),
//            DateTimeFormatter.ofPattern("MM.dd.yyyy"),
//            DateTimeFormatter.ofPattern("yyyy.MM.dd"),
//            DateTimeFormatter.ofPattern("d MMM yyyy"),
//            DateTimeFormatter.ofPattern("MMM d, yyyy"),
//            DateTimeFormatter.ofPattern("d MMMM yyyy"),
//            DateTimeFormatter.ofPattern("MMMM d, yyyy")
            DateTimeFormatter.ofPattern("M/d/yyyy"),
            DateTimeFormatter.ofPattern("MM/dd/yyyy"),
            DateTimeFormatter.ofPattern("M-d-yyyy"),
            DateTimeFormatter.ofPattern("MM-dd-yyyy"),
            DateTimeFormatter.ofPattern("MMM d, yyyy"),
            DateTimeFormatter.ofPattern("MMMM d, yyyy"),
            DateTimeFormatter.ofPattern("MMM dd yyyy"),
            DateTimeFormatter.ofPattern("MMMM dd yyyy")

    );

    public Map<String, List<PdfMetaData>> getMetaData(File file, Claims claims) throws IOException {
        PDDocument document = PDDocument.load(file);
        Map<String, List<PdfMetaData>> metadata = new HashMap<>();
         Map<String,String>labelExisted = new HashMap<>();
         Map<String,String> dateLabelExisted = new HashMap<>();

        Properties properties = new Properties();
//        properties.load(new FileInputStream("src/main/resources/application.properties"));
        properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));

        List<String> dobLabels = getLabels(properties.getProperty("labels.dob"));
        List<String> dobLabels1 = getLabels(properties.getProperty("labels.dob1"));
        List<String> dosLabels = getLabels(properties.getProperty("labels.dos"));
        List<String> firstnameLabels = getLabels(properties.getProperty("labels.firstname"));
        List<String> middlenameLabels = getLabels(properties.getProperty("labels.middlename"));
        List<String> lastnameLabels = getLabels(properties.getProperty("labels.lastname"));

        Pattern datePattern = buildDatePattern(dobLabels, dosLabels);

        PDFTextStripper stripper = new PDFTextStripper();
        int totalPages = document.getNumberOfPages();

        for (int page = 1; page <= totalPages; page++) {
            stripper.setStartPage(page);
            stripper.setEndPage(page);
            String text = stripper.getText(document);

            System.out.println("Processing page " + page);
            System.out.println("Page text: " + text);

            extractFieldByLabels(text, firstnameLabels, "First Name", metadata, page,labelExisted);
            extractFieldByLabels(text, middlenameLabels, "Middle Name", metadata, page,labelExisted);
            extractFieldByLabels(text, lastnameLabels, "Last Name", metadata, page,labelExisted);
            extractDateByLabels(text, dobLabels, "DOB", metadata, page,dateLabelExisted);
            extractDateByLabels(text, dobLabels1, "DOS", metadata, page,dateLabelExisted);

            Matcher dateMatcher = datePattern.matcher(text);
            while (dateMatcher.find()) {
                String label = dateMatcher.group(1).toUpperCase();
                String rawDate = dateMatcher.group(1);
                System.out.println("Found date: " + rawDate + " with label: " + label);
                String parsedDate = normalizeDate(rawDate);
                System.out.println("Normalized date: " + parsedDate);

                if (parsedDate != null) {
                    if (label.contains("DOB")) {
                        addToMetadataList(metadata, "DOB", parsedDate, page);
                    }
                    if (label.contains("DOS")) {
                        addToMetadataList(metadata, "DOS", parsedDate, page);
                    }
                }
            }
        }

        document.close();
        metadata.forEach((key, list) -> list.forEach(meta -> System.out.println(key + ": " + meta)));
        return metadata;
    }



    private static void extractFieldByLabels(String text, List<String> labels, String key, Map<String, List<PdfMetaData>> metadata, int page,Map<String,String>labelExisted) {

        for (String label : labels) {
            Pattern pattern =Pattern.compile("");
            if(labelExisted.containsKey(label)){
                pattern = Pattern.compile("(?i)" + Pattern.quote(labelExisted.get(label)) + "\\s*[:\\-]?\\s*([A-Z'\\-\\.]+(?: [A-Z'\\-\\.]+)*)");
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    String value = labelExisted.get(label);
                    log.info("Matched DOB: {}", value);
                    addToMetadataList(metadata, key, value, page);
                    break;
                }

            } else {
                 pattern = Pattern.compile("(?i)"+Pattern.quote(label)+"\\s*[:\\-]?\\s*([A-Z0-9'\\-\\. ]+)(?=\\s{2,}|\\n|$)");
                Matcher matcher = pattern.matcher(text);
                 while (matcher.find()) {
                    String value = matcher.group(1).trim().replaceAll("\\s+", " ");
                    labelExisted.put(label,value);
                    log.info("Matched DOB: {}", value);
                    addToMetadataList(metadata, key, value, page);
                    break;
                }
            }
        }
    }

    private static void extractDateByLabels(String text, List<String> labels, String key, Map<String, List<PdfMetaData>> metadata, int page,Map<String,String>dateLabelExisted) {
        System.out.println("Extracting dates from page " + page);
        System.out.println("Page text: " + text);

        for (String label : labels) {
//            String datePattern = "(?i)" + Pattern.quote(label) + "\\s*[:\\-]?\\s*"
//                    + "((?:\\d{1,2}[\\/\\-\\.]){2}\\d{2,4}"
//                    + "|\\d{4}[\\/\\-]\\d{1,2}[\\/\\-]\\d{1,2}"
//                    + "|[A-Za-z]{3,9}\\s\\d{1,2},\\s\\d{4}"
//                    + "|\\d{1,2}\\s+[A-Za-z]{3,9}\\s+\\d{4}"
//                    + "|[A-Za-z]{3,9}\\s\\d{1,2}(st|nd|rd|th)?,\\s\\d{4})"
//                    + "(?=\\s|$|\\s{1,})";
//
//            Pattern pattern = Pattern.compile(datePattern);
//            Matcher matcher = pattern.matcher(text);
//
//            while (matcher.find()) {
//                String rawDate = matcher.group(1).trim();
//                System.out.println("Found raw date: " + rawDate);
//                String parsedDate = normalizeDate(rawDate);
//                if (parsedDate != null) {
//                    addToMetadataList(metadata, key, parsedDate, page);
//                } else {
//                    System.out.println("Failed to parse date: " + rawDate);
//                }
//            }


            Pattern pattern = Pattern.compile("");

            if (dateLabelExisted.containsKey(label)) {
                pattern = Pattern.compile("(?i)" + Pattern.quote(dateLabelExisted.get(label)) + "\\s*[:\\-]?\\s*(.+?)(?=\\s+[A-Z][a-zA-Z]+\\s*[:\\-]|\\n|$)");
                Matcher matcher = pattern.matcher(text);
                if (matcher.find()) {
                    String value = dateLabelExisted.get(label);
                    log.info("Matched DOB: {}", value);
                    addToMetadataList(metadata, key, value, page);
                }
            } else {
                pattern = Pattern.compile("(?i)" + "\\b"+Pattern.quote(label) +"\\b"+ "\\s*[:\\-]?\\s*(.+?)(?=\\s+[A-Z][a-zA-Z]+\\s*[:\\-]|\\n|$)");
                Matcher matcher = pattern.matcher(text);
                if (matcher.find()) {
                    String value = matcher.group(1).trim();
                    dateLabelExisted.put(label, value);
                    log.info("Matched DOB: {}", value);
                    addToMetadataList(metadata, key, value, page);
                }
            }

        }





    }

    private static void addToMetadataList(Map<String, List<PdfMetaData>> metadata, String key, String value, int page) {
        List<PdfMetaData> list = metadata.computeIfAbsent(key, k -> new ArrayList<>());

        for (PdfMetaData meta : list) {
            if (meta.getValue().equalsIgnoreCase(value)) {
                meta.addPage(page);
                return;
            }
        }

        list.add(new PdfMetaData(value, page));
    }

    private static String normalizeDate(String dateStr) {
        String cleaned = dateStr.replaceAll("(st|nd|rd|th)", "").trim();
        System.out.println("Attempting to normalize date: " + cleaned);


        for (DateTimeFormatter fmt : DATE_FORMATS) {
            try {
                LocalDate parsedDate = LocalDate.parse(cleaned, fmt);
                System.out.println("Parsed date: " + parsedDate + " using format: " + fmt);
                return parsedDate.format(DateTimeFormatter.ISO_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Failed to parse date: " + cleaned + " using format: " + fmt);
            }
        }
        return null;
    }


    private static List<String> getLabels(String labels) {
        return labels == null ? List.of() : Arrays.stream(labels.split(","))
                .map(String::trim)
                .filter(lb -> !lb.isEmpty())
                .toList();
    }

    private static Pattern buildDatePattern(List<String> dobLabels, List<String> dosLabels) {
        Set<String> all = new HashSet<>();
        all.addAll(dobLabels);
        all.addAll(dosLabels);
        if (all.isEmpty()) return Pattern.compile("(?!)");

        String labelPattern = String.join("|", all)
                .replaceAll("([.?^$+*()\\[\\]{}|\\\\])", "\\\\$1");

        return Pattern.compile("(?i)(" + labelPattern + ")[\\s:;\\-]*([A-Za-z0-9 ,./-]{6,})");
    }
    
    // new method implementation getting value from claims
    
    
    
    
    
}
