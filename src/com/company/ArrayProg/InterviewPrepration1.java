package com.company.ArrayProg;

import java.util.Arrays;

public class InterviewPrepration1 {

    public void bubbleSort(int[]arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
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
        int[]arr = {23,87,56,98,109,453};
        InterviewPrepration1 prep = new InterviewPrepration1();
        prep.bubbleSort(arr);
    }
}
