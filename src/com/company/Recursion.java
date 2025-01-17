package com.company;

import java.util.Scanner;

public class Recursion {
    static void validate(String str){
        if(str.length() == 6){
            System.out.println("Your pin is matched");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Re-Enter the pin");
            String str1 = sc.next();
            validate(str1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the pin");
        String str2 = sc.next();
        validate(str2);
    }
}
