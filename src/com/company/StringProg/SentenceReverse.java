package com.company.StringProg;

public class SentenceReverse {
    public static void reverse(String str) {
        char[] st = str.toCharArray(); // Convert string to character array
        int left = 0, right = st.length - 1;

        while (left < right) {
            if((((int)st[left]>=65 && (int)st[left]<=90)||((int)st[left]>=97 && (int)st[left]<=122)) && (((int)st[right]>=65 && (int)st[right]<=90)||((int)st[right]>=97 && (int)st[right]<=122))){
                // Swap characters at 'left' and 'right'
                char temp = st[left];
                st[left] = st[right];
                st[right] = temp;
                left++;
                right--;
            } else if ((((int)st[left]>=65 && (int)st[left]<=90)||((int)st[left]>=97 && (int)st[left]<=122)) && !(((int)st[right]>=65 && (int)st[right]<=90)||((int)st[right]>=97 && (int)st[right]<=122))) {
                right--;
            } else {
                left++;
            }

        }

        System.out.println("Reverse String Result is: " + new String(st));
    }

    public static void main(String[] args) {
        reverse("My name");
    }
}