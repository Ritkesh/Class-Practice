package com.company.java8features;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {

        // Function<String,Integer>  means input is String and return value will be Integer
        // Function will do the work assigned to it
        Function<String,Integer> integerFunction = x-> x.length();

        System.out.println(integerFunction.apply("Ritkesh"));

        Function<String,String> stringStringFunction = x-> x.substring(0,3);
        System.out.println(stringStringFunction.apply("Ritkesh"));


        System.out.println("Using andThen");

        Function<Integer,Integer> funMul = x-> x*2;
        Function<Integer,Integer> funCube = x-> x*x*x;
        //first funcMul will do the task and then funCube o/p will be 64
        System.out.println(funMul.andThen(funCube).apply(2));
        //first funCube will do the task and then funcMul o/p will be 16
        System.out.println(funCube.andThen(funMul).apply(2));
        //first funCube will do the task and then funcMul o/p will be 16
        System.out.println(funMul.compose(funCube).apply(2));

        // identity function it is static method of function
        // it will return the same value as input

        System.out.println("using identity function");

        Function<String,String> identityFunction =  Function.identity();
        System.out.println(identityFunction.apply("Ram"));




    }
}
