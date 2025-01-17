package com.company.ArrayProg;

import java.util.Arrays;

public class LeftRotateInArray {
    public void leftRotateArray(int[]arr){
        int[]resultantArr = new int[arr.length];
        for(int i = 1; i < arr.length; i++){
            resultantArr[i-1] = arr[i];
        }
        resultantArr[arr.length-1]= arr[0];
        System.out.println(Arrays.toString(resultantArr));
    }

    public static void main(String[] args) {
        int[] array  = {1,2,3,4,5};
        LeftRotateInArray lft = new LeftRotateInArray();
        lft.leftRotateArray(array);
    }
}
