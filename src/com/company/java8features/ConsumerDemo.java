package com.company.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {

        // consumer accept the input and consumes there is no return value


        Consumer<String> stringConsumer = x-> System.out.println(x);

        stringConsumer.accept("Ram");

        Consumer<List<Integer>> intList1 = li->{
            for(Integer i : li){
                System.out.println(i+100);
            }
        };

        Consumer<List<Integer>> intList2 = li->{
            for(Integer i : li){
                System.out.println(i);
            }
        };
        intList2.andThen(intList1).accept(Arrays.asList(1,2,3,4,5,6,7,8,9));

    }
}
