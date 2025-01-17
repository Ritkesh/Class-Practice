package com.company;

interface Itest1{
    void add (int n1,int n2);
}

public class LambdaExpression extends Order {
     static void add(){}
    public static void main(String[] args) {
        Order order = new Order();
        dis();
        order.itest.add(5,3);
        LambdaExpression ld = new LambdaExpression();
        add();
        ld.itest.add(7,8);

        Itest1 itest = (n1,n2)-> System.out.println(n1+n2);

        itest.add(5,3);




    }

}
