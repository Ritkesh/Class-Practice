package com.company.ArrayProg;

import java.util.Arrays;

public class Array2DAddition {
    public void addition(int[][]arr1,int[][]arr2){
        int[][]result = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        System.out.println("Resultant matrix after addition:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Array2DAddition addition = new Array2DAddition();
        int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] array2 = {{7, 8, 9}, {10, 11, 12}};
        addition.addition(array1, array2);
    }
}
