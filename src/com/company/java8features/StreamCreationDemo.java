package com.company.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreationDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple","Banana","Orange","Papaya");
        Stream<String> myStream = list.stream();
        
        String[] arr = {"Apple","Banana","Orange","Papaya"};
        Stream<String> stream = Arrays.stream(arr);

        // creation of stream by using stream

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // creation pf stream by iteration
        Stream<Integer> limit = Stream.iterate(0, n -> n + 1).limit(100);

        // creation of stream using generator
        Stream<String> limit1 = Stream.generate(() -> "Hello").limit(5);

    }
}
