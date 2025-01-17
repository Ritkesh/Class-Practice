package com.company.ArrayProg;

public class DuplicateElementInArray {
    public void duplicateElement(int[] arr) {
        boolean[] elementPrinted = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // Skip elements already processed
            if (elementPrinted[i]) continue;

            boolean isDuplicate = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    elementPrinted[j] = true; // Mark duplicates
                    isDuplicate = true;      // Mark current as duplicate
                }
            }

            // Print the element if it's a duplicate
            if (isDuplicate) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 1, 2, 5, 2, 4, 6, 5, 7, 3, 6, 7};
        DuplicateElementInArray dp = new DuplicateElementInArray();
        dp.duplicateElement(array);
    }
}
