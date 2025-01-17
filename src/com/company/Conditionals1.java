package com.company;

import java.util.Scanner;

public class Conditionals1 {
    String eid;
    String ename;
    double esalary;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Method.Display();
        Method method = new Method();
        method.Add();
        Conditionals1 cond = new Conditionals1();
        System.out.println("enter the employee name");
        cond.ename = sc.next();
        System.out.println("Enter the emplyee id");
        cond.eid = sc.next();
        System.out.println("Enter the employee salary");
        cond.esalary = sc.nextDouble();
        if (cond.esalary> 1000){
            System.out.println("Salary is good");

        }else{
            System.out.println("Average Salary");
        }


    }

}
