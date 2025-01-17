package com.company.ArrayProg;

public class DuplicacyCheckAndRemove {
    public void duplicacyRemoval(String str) {
        StringBuilder result = new StringBuilder(); // To build the resulting string
        boolean[] seen = new boolean[256];          // Tracks if a character has been processed
        boolean[] duplicate = new boolean[256];     // Tracks if a character is duplicate

        for (char ch : str.toCharArray()) {
            if (seen[ch]) {
                duplicate[ch] = true;               // Mark as duplicate if seen before
            }
            seen[ch] = true;
        }

        for (char ch : str.toCharArray()) {
            if (!duplicate[ch]) {                  // Add only non-duplicate characters
                result.append(ch);
            }
        }

        System.out.println(result.toString());      // Print the result
    }

    public static void main(String[] args) {
        DuplicacyCheckAndRemove dr = new DuplicacyCheckAndRemove();
        dr.duplicacyRemoval("Gautam Kumar");
    }
}
