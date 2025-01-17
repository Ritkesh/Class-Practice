package com.company.StringProg;

public class WordReverse {
    public static void reverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {

            reversed += str.charAt(i);
        }



        System.out.println("Reverse String Result is: " + new String(str));
    }

    public static void main(String[] args) {
        reverse("My name");
    }
}