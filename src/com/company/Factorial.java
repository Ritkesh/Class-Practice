package com.company;

import java.util.Scanner;

public class Factorial {
    static int factorial(int n){
        if (n == 0)
            return 1;
        else
            return(n * factorial(n-1));
    }
    int fact(int n){
        int result = 1;
        if(n == 0|| n== 1){
            result =1;
            return result;
        } else{
            for (int i = n ;i>1;i--){
                result = result*i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = sc.nextInt();
        Factorial ft  = new Factorial();
        int result = ft.fact(num);
//       int result =  Factorial.factorial(num);
        System.out.println("Factorial is"+":"+result);
    }
}
