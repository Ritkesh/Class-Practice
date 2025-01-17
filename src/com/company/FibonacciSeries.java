package com.company;

import java.util.Scanner;

public class FibonacciSeries {
    int fib(int n){
        int result;
        if(n == 0){
            result = 0;
            return result;
        }
        if(n == 1) {
            result = 1;
            return result;
        }
           return result = fib(n-1) + fib(n-2);
    }
    void fibc(int n){

        int result ;
        int firstNumber =0, secondNumber =1;
        for(int i = 0; i < n; i++){
             int nextNumber  = firstNumber + secondNumber;
            System.out.print(firstNumber + " ");
            firstNumber = secondNumber;
             secondNumber = nextNumber;

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = sc.nextInt();
        FibonacciSeries fs = new FibonacciSeries();
        fs.fibc(num);
//        for (int i = 0; i< num;i++) {
//            int result = fs.fib(i);
//            System.out.print(result+" ");
//        }
    }

}
