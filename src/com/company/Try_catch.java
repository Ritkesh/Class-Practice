package com.company;

class Calc{
    public void division(int n1,int n2) throws Exception{

            System.out.println("The result is" + ":"+ n1/n2);
    }
}


public class Try_catch {
    public static void main(String[] args)  {

        Calc calc = new Calc();
        try {
            calc.division(5,0);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
