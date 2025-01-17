package com.company;

class Calculation1{
    public void division(int n1,int n2){

        try{
           int j = n1/n2;
            if(j == 0)
            throw new ArithmeticException("HI");
        } catch (ArithmeticException e){
            int j = 1/1;
           System.out.println("The numerator should be greater than Zero" + e.getMessage());
            System.out.println(j);
        }
    }
}

public class Throw_throws1 {
    public static void main(String[] args) {
        Calculation1 cal = new Calculation1();
        cal.division(0,15);
        System.out.println("division executed successfully");

    }
}
