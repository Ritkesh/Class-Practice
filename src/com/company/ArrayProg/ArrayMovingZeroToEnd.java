package com.company.ArrayProg;

import java.util.Arrays;

public class ArrayMovingZeroToEnd {
    public void movingZero(int[] arr) {
        int j = 0; // Pointer to track the position of non-zero elements

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // Swap non-zero element with the element at position 'j'
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++; // Move the pointer to the next position
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] ar = {1,2,0,3,};
        ArrayMovingZeroToEnd zte = new ArrayMovingZeroToEnd();
        zte.movingZero(ar);
    }
}
