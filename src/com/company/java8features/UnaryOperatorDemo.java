package com.company.java8features;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
    public static void main(String[] args) {
        Function<Integer,Integer> function1 = x-> x*2;
        System.out.println(function1.apply(2));

        // when argument and return type is same in Function then we can use unaryOperator
        System.out.println("After applying unaryOperator");
        UnaryOperator<Integer> unaryOperator1 = x->x*2;
        System.out.println(unaryOperator1.apply(4));

        Function<String, String> stringFunction = x-> x.toLowerCase();

        System.out.println(stringFunction.apply("RADHE"));

        System.out.println("After applying unary operator");

        UnaryOperator<String> stringUnaryOperator = x->x.toLowerCase();
        System.out.println(stringUnaryOperator.apply("SHYAM"));
    }
}
