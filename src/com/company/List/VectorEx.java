package com.company.List;

import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {
        // creation of vector
        System.out.println("creation of vector");
        Vector<Integer> vector = new Vector<>();
        // we can check the capacity of a vector
        System.out.println("we can check the capacity of a vector");
        System.out.println(vector.capacity());
        //adding element to vector
        System.out.println("adding element to vector");
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        System.out.println(vector);
    }
}
