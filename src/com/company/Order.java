package com.company;

interface Itest{
    void add (int n1,int n2);
}

 abstract class Test2 {
     abstract void multiply(int n1, int n2);
}

public class Order  {
    public static void dis(){
        System.out.println("Hi");
    }
    Itest itest = new Itest() {
        public void add(int n1, int n2) {
            System.out.println(n1+n2);

        }
    };
    public static void main(String[] args) {

       Order yt = new Order();
       yt.dis();
       yt.itest.add(5,3);

        Test2 test2 = new Test2() {
            @Override
            void multiply(int n1, int n2) {

            }
        };

    }
}
