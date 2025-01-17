package com.company.List;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListEx {

    public static void main(String[] args) {
        // creation of linkedlist
        System.out.println("creation of linkedlist");
        LinkedList<Integer> list  = new LinkedList<>();
        // adding element in linkedlist
        System.out.println("adding element in linkedlist");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);
        // adding element at first
        System.out.println("adding element at first");
        list.addFirst(0);
        System.out.println(list);
        // adding element at last
        System.out.println("adding element at last");
        list.addLast(7);
        System.out.println(list);
        // get element from list at particular index
        System.out.println("get element from list at particular index");
        System.out.println(list.get(2));
        // get first element from list
        System.out.println("get first element from list");
        System.out.println(list.getFirst());
        // get last element from list
        System.out.println("get last element from list");
        System.out.println(list.getLast());

        // creation of linkedlist on the fly
        System.out.println("creation of linkedlist on the fly");
        LinkedList<String> animal = new LinkedList<>(Arrays.asList("Elephant","Dog","Cat"));
        System.out.println(animal);
        // removing using removeAll
        System.out.println("removing using removeAll");
        LinkedList<String>animalToRemove = new LinkedList<>(Arrays.asList("Dog"));
        animal.removeAll(animalToRemove);
        System.out.println(animal);

        //using removeIf method
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(7);
        list2.add(8);
        list2.add(9);
        list2.add(10);
        list2.add(15);
        System.out.println("before remove if");
        System.out.println(list2);
        list2.removeIf(x->x%2==0);
        System.out.println("after remove if");
        System.out.println(list2);

    }
}
