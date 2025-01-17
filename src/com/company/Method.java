package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public  class Method {
    int num1 =10;
    int num2 = 0;
    void Add(){
        System.out.println(num1+num2);
    }
    static void Display(){
        System.out.println("This is static method");

    }

    public static void main(String[] args) {
//        Method.Display();
//        Method method = new Method();
//        method.Add();
        List<Integer> intList = Arrays.asList(1,3,2,4,3,1,2);
//        Set<Integer> integers = new HashSet<Integer>();
//            for (Integer integer : intList) {
//                integers.add(integer);
//
//        }
           List<Integer> sortedList = intList.stream().distinct().sorted((a,b)-> -a.compareTo(b)).collect(Collectors.toList());
        System.out.println(sortedList);

    }
}

