package com.company.ArrayProg;

import java.util.Arrays;

public class RightRotateInArray {
    public void rightRotateArray(int[]arr){
        int[]resultantArr = new int[arr.length];
        for(int i = 0; i < arr.length-1; i++){
            resultantArr[i+1] = arr[i];
        }
        resultantArr[0]= arr[arr.length-1];
        System.out.println(Arrays.toString(resultantArr));
    }

    public static void main(String[] args) {
        int[] array  = {1,2,3,4,5};
        RightRotateInArray rght = new RightRotateInArray();
        rght.rightRotateArray(array);
    }
}
