package com.company.java8features;

import java.util.function.BiPredicate;

public class BiPredicateDemo {
    public static void main(String[] args) {
        BiPredicate<Integer,Integer> biPredicate = (x,y)-> x%2==0 && y%2==0;

        System.out.println(biPredicate.test(4,8));
    }
}
