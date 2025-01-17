package com.company.ArrayProg;

public class ArrayLargestElement {
    public void largestElement(int[] arr) {
        // Initialize max and min to the first element of the array
        int max_number = arr[0];
        int min_number = arr[0];

        // Loop through the array to find the largest and smallest numbers
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max_number) {
                max_number = arr[i];
            }
            if (arr[i] < min_number) {
                min_number = arr[i];
            }
        }

        // Print the largest and smallest elements
        System.out.println("Largest Element: " + max_number);
        System.out.println("Smallest Element: " + min_number);
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 34, 56, 98};
        ArrayLargestElement le = new ArrayLargestElement();
        le.largestElement(arr);
    }
}
