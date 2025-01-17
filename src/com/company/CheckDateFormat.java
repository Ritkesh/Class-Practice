//package com.company;
//
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//import java.util.Locale;
//
//public class CheckDateFormat {
//
//    public void dateInIsoFormat (String date) {
//        try {
//            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
//            ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateStr, inputFormatter);
//            BsonDateTime bsonDateTime = new BsonDateTime(zonedDateTime.toInstant().toEpochMilli());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public static void main(String[] args) {
//        CheckDateFormat  cdf = new CheckDateFormat();
//        cdf.dateInIsoFormat("Fri, 02 Aug 2024 17:58:52 IST");
//
//    }
//
//}
