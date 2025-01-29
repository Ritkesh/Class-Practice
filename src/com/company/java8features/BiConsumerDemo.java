package com.company.java8features;

import java.util.function.BiConsumer;

public class BiConsumerDemo {

    public static void main(String[] args) {
        BiConsumer<Integer,Integer> biConsumerDemo = (x, y)-> System.out.println(x+y);

        biConsumerDemo.accept(5,7);




        // there is no concept of bisupplier since supplier doesnot accept any argument it only
        // return a value . so inly a value can be returned at a time , multiple value cannot be returned at a time
        // so the concept of bi supplier is doesnot exist
    }
}
