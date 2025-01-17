package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {


    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(10,98,87,76,34,55);
        List<Integer> oddNumberList = integerList.stream()
                                                  .filter(i -> i%2 != 0)
                                                    .collect(Collectors.toList());
        System.out.println(oddNumberList);
        List<Integer> modifyNumberList = integerList.stream().map(i-> i+5).filter(j -> j > 0).collect(Collectors.toList());
        System.out.println(modifyNumberList);
        List<Integer> sortedNumber = integerList.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumber);
        List<Integer> decreasingsortedNumber = integerList.stream().sorted((a,b)-> -a.compareTo(b)).collect(Collectors.toList());
        System.out.println(decreasingsortedNumber);
        List<String> stringList = Arrays.asList("A","C","G","D","AA","BB","AAA","CCC");
        List<String> modifyStringList = stringList.stream().sorted().collect(Collectors.toList());
        System.out.println(modifyStringList);
        List<String> modifyStringList2 = stringList.stream().sorted((a,b)->Integer.compare(a.length(),b.length())).collect(Collectors.toList());
        System.out.println(modifyStringList2);
    }
}
