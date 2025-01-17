package com.company;

class Calculation{
    public void division(int n1,int n2){

        try{
            System.out.println("The result is" + ":"+ n1/n2);
        } catch (ArithmeticException e){
//            int j = n1/1;
            System.out.println("The numerator should be greater than Zero" + e.getMessage());
//            System.out.println(j);
        }
    }
}

public class Throw_throws {
    public static void main(String[] args) {
        Calculation cal = new Calculation();
        cal.division(5,0);
        System.out.println("division executed successfully");

    }


}
