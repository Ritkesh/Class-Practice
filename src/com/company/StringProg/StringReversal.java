package com.company.StringProg;

public class StringReversal {

    public static void main(String[] args) {
        String str = "Hello World";
        char[] charArray = str.toCharArray();
        int left = 0, right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        String reversed = new String(charArray);
        System.out.println(reversed); // Output: olleH
    }
}
