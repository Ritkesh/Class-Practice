package com.company.ArrayProg;

import java.util.Arrays;

public class ArraySecondLargestElement {

    public void secondLargestElement(int[]arr){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            if (arr[i]>max) {
                secondMax = max;
                max = arr[i];
            }
        }
        System.out.println("The Second Largest Element is"+":"+""+secondMax);
    }

    public static void main(String[] args) {
        int[] arr = {1,77,95,34,67,99};
        System.out.println(Arrays.toString(arr));
        ArraySecondLargestElement arsc = new ArraySecondLargestElement();
        arsc.secondLargestElement(arr);
    }
}
