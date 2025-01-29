package com.company.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamOperationDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 5, 98, 75, 69, 88, 64, 96, 96);
        List<Integer> collect = list.stream().filter(x -> x % 2 == 0)
                .map(x -> x + 2)
                .collect(Collectors.toList());// it will return mutable list

        collect.add(10);
        System.out.println(collect);

        List<Integer> collect1 = list.stream().filter(x -> x % 2 == 0)
                .map(x -> x + 2)
                .toList(); // return immutable list

        //collect1.add(12); // it will throw an runtime error because it is immutable .
        System.out.println(collect1);

        //distinct value no repetition

        List<Integer> collect2 = list.stream().filter(x -> x % 2 == 0)
                .map(x -> x + 2)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect2);

        // sorting natural sorting

        System.out.println("natural sorting");

        List<Integer> collect3 = list.stream().filter(x -> x % 2 == 0)
                .map(x -> x + 2)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(collect3);

        // customize sorting

        System.out.println("customize sorting");

        List<Integer> collect4 = list.stream().filter(x -> x % 2 == 0)
                .map(x -> x + 2)
                .distinct()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());

        System.out.println(collect4);

        // using limit

        System.out.println("using limit");

        List<Integer> collect5 = list.stream().filter(x -> x % 2 == 0)
                .map(x -> x + 2)
                .distinct()
                .sorted((a, b) -> b - a)
                .limit(4)
                .collect(Collectors.toList());

        System.out.println(collect5);

        System.out.println("using skip");

        List<Integer> collect6 = list.stream().filter(x -> x % 2 == 0)
                .map(x -> x + 2)
                .distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .limit(4)
                .collect(Collectors.toList());

        System.out.println(collect6);

        // to find max value

        System.out.println("to find max value");

        List<Integer> list1 = Arrays.asList(1, 5, 98, 75, 69, 88, 64, 96, 96);

        Integer integer = list1.stream().max((a, b) -> a - b).get();
        System.out.println(integer);

        // to find min value

        System.out.println("to find min value");

        Integer integer1 = list1.stream().min((a, b) -> a - b).get();
        System.out.println(integer1);

        // parallelStream is same as stream but it is used when data size is very large


    }
}
