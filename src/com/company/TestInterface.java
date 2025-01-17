package com.company;

interface Itest2{
    void add (int n1,int n2);
    void subtract (int n1,int n2);

}

public class TestInterface implements Itest2 {
    public void add(int n1, int n2) {
        System.out.println(n1+n2);
    }
    public void subtract(int n1, int n2) {
        System.out.println(n2-n1);

    }
    public void singing(){
        System.out.println("Parrot sings like a human");
    }

    public static void main(String[] args) {
        TestInterface interface1 = new TestInterface();
        interface1.add(5,3);
        interface1.subtract(5,7);

    }
}
