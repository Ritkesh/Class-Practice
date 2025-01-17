package com.company.ArrayProg;

public class ArrayAddition {
    public void arrayAddition(int[]arr1,int[]arr2){
        int[]result = new int[arr1.length];
        for(int i = 0;i<arr1.length;i++){
            result[i] = arr1[i]+arr2[i];
        }
        for (int arr:result) {
            System.out.println(arr);
        }
    }

    public static void main(String[] args) {
        ArrayAddition arrayAddition = new ArrayAddition();
       arrayAddition.arrayAddition(new int[]{1,2,3,4},new int[]{5,6,7,8});
    }
}
