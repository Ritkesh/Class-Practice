package com.company.java8features;

import java.util.Arrays;

public class StreamDemo1 {

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,8,9,10,76};
        System.out.println("without using stream");
        int sum =0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]%2==0){
                sum+= arr[i];
            }
        }
        System.out.println(sum);

        System.out.println("By using stream");

        int sum1 = Arrays.stream(arr)
                .filter(x->x%2==0)
                .sum();
        System.out.println(sum1);
    }
}
