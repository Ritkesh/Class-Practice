package com.company.ArrayProg;

import java.util.Arrays;

public class ArrayInReverseOrder {
    public void reverseArray(int[] arr){
        int temp =0;
        for(int i=0;i<arr.length/2;i++){
            temp = arr[i];
            arr[i]= arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6};
        ArrayInReverseOrder rv = new ArrayInReverseOrder();
        rv.reverseArray(num);
    }
}
