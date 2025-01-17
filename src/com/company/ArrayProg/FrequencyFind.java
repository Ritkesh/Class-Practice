package com.company.ArrayProg;

import java.util.Arrays;

public class FrequencyFind {

    public void frequencyFinder(int[] arr) {
        // Array to track if an element is already counted
        boolean[] counted = new boolean[arr.length];

        // Loop through the array to find the frequency of each element
        for (int i = 0; i < arr.length; i++) {
            // Skip if the element has already been counted
            if (counted[i]) continue;

            int count = 1; // Start counting the current element
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    counted[j] = true; // Mark as counted
                }
            }

            // Output the frequency of the current element
            System.out.println("Frequency of " + arr[i] + " is " + count);
        }
    }

    public static void main(String[] args) {
        int[] numberArr = {1, 2, 4, 1, 3, 5, 2, 4};
        FrequencyFind ff = new FrequencyFind();
        ff.frequencyFinder(numberArr);
    }
}
