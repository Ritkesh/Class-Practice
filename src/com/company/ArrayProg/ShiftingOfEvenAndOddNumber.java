package com.company.ArrayProg;

import java.util.Arrays;

public class ShiftingOfEvenAndOddNumber {
    public void shift(int[]arr){
        int evenIdex = 0;
        int oddIndex = arr.length-1;
        int[]resultantArr = new int[arr.length];
        for(int i = 0;i< arr.length;i++){
            if(arr[i]%2==0){
                resultantArr[evenIdex]=arr[i];
                evenIdex++;
            } else{
                resultantArr[oddIndex]= arr[i];
                oddIndex--;
            }
        }
        System.out.println(Arrays.toString(resultantArr));
    }

    public static void main(String[] args) {
        int[]arr = {2,1,4,6,3,8,7,9,9,12,11};
        ShiftingOfEvenAndOddNumber sfoe = new ShiftingOfEvenAndOddNumber();
        sfoe.shift(arr);
    }
}
