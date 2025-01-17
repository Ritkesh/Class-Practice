package com.company;

import java.util.ArrayList;
import java.util.ListIterator;

public class CursorEx4 {
    public static void main(String[] args) {
        ArrayList<String> obj = new ArrayList<>();
        obj.add("Raja");
        obj.add("Ratan");
        obj.add("Shyam");
        ListIterator<String> itr = obj.listIterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("********");
        while (itr.hasPrevious()){
            System.out.println(itr.previous());
        }
        System.out.println("*****");
        ListIterator<String> it = obj.listIterator(1);
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
