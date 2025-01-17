package com.company.ArrayProg;

import java.util.Arrays;

public class ArrayAscendingOrder {
    public void ascending(int[]arr){
         for(int i=0;i<arr.length;i++){
             for(int j = i+1;j< arr.length;j++){
                 if(arr[i]>arr[j]){
                     int temp = arr[i];
                     arr[i] = arr[j];
                     arr[j]= temp;
                 }
             }
         }
        System.out.println(Arrays.toString(arr));

        }



    public static void main(String[] args) {
        int[] arr = {34,78,98,56,9,7,4,3,87,78};
        ArrayAscendingOrder asc = new ArrayAscendingOrder();
        asc.ascending(arr);
    }
}
