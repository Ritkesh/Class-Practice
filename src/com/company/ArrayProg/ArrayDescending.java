package com.company.ArrayProg;

import java.util.Arrays;

public class ArrayDescending {
    public void descending(int[]arr){
        for(int i = 0;i< arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i]= arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1,3,54,67,83,45,54};
        ArrayDescending des = new ArrayDescending();
        des.descending(arr);

    }
}
