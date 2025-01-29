package com.company.java8features;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {
    public static void main(String[] args) {
        BiFunction<String,String,String> biFunction = (s1,s2)-> s1.concat(s2);
        // when the datatype of both input and return type is same then we can use binary operator
        // above operation can be done using binaryOperator

        BinaryOperator<String> binaryOperator = (s1,s2)-> s1.concat(s2);

        System.out.println(biFunction.apply("Ram","Shyam"));

        System.out.println("using binary operator");

        System.out.println(binaryOperator.apply("Ram","Shyam"));
    }
}
