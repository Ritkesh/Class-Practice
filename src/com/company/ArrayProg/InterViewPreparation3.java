package com.company.ArrayProg;

import java.util.Arrays;

public class InterViewPreparation3 {
    public void movingZeroToEnd(int[]arr){
        int j = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i]  = arr[j];
                arr[j] = temp;
                j++;
            }



        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        InterViewPreparation3 prep3 = new InterViewPreparation3();
        int[]arr = {0,1,2,3,0,4,5,0,7,0,9};
        prep3.movingZeroToEnd(arr);
    }
}
