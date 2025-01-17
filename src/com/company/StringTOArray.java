package com.company;

import java.util.Arrays;

public class StringTOArray {
    public static void main(String[] args) {
        String city = "patna";
        String [] cityList  = new String[0];
        cityList = new String[]{city};
        for (String element: cityList) {
            System.out.println(element);
        }


    }
}
