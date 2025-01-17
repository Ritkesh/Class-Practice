package com.company;

import java.util.Scanner;

public class CeilFloor {
    public static void main(String[] args) {
        //for ceil testing
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check ceil function");
        double x = sc.nextDouble();
        double y = Math.ceil(x);
        System.out.println("The ceil value of x is"+":"+y);
        // for floor testing
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter a number to check floor function");
        double p = sc1.nextDouble();
        double q = Math.floor(p);
        System.out.println("The floor value of x is"+":"+q);
        // for rint testing
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter a number to check rint function");
        double a = sc3.nextDouble();
        double b = Math.rint(a);
        System.out.println("The rint value of a is"+":"+b);
    }
}
