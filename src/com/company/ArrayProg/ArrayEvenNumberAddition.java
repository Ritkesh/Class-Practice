package com.company.ArrayProg;

import java.util.Scanner;

public class ArrayEvenNumberAddition {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        if(arr.length>=1){
            for(int i=0;i<n;i++){
                System.out.println("enter the number");
                int n1 = sc.nextInt();
                arr[i] = n1;
            }
            int sum = 0;

            for(int j = 0; j< arr.length;j++){
                if(arr[j]%2==0){
                    sum =sum+arr[j];

                }
            }
            System.out.println(sum);
        }
    }
}
