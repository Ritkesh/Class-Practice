package com.company;

import java.time.LocalDate;

public class DateAddTest {


    //Example to Add months to a Date

        public static void main(String[] args){

            // Take a date
            LocalDate date = LocalDate.parse("2020-05-03");
            // Displaying date
            System.out.println("Date : "+date);
            // Add 2 months to the date
            LocalDate newDate = date.plusMonths(15);
            System.out.println("New Date : "+newDate);
        }
    }

