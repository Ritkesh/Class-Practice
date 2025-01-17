package com.company.ArrayProg;

public class ArrayOnEvenPosition {
    public void evenPosition(int[]arr){
        int i = 1;
        if(arr.length>=1){
            for(i=1;i< arr.length;i+=2){
                System.out.println(arr[i]);

            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ArrayOnEvenPosition even = new ArrayOnEvenPosition();
        even.evenPosition(arr);
    }
}
