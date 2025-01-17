package com.company;

import java.util.ArrayList;
import java.util.ListIterator;

public class CursorEx3 {
    public static void main(String[] args) {
        ArrayList<String> object = new ArrayList<>();
        object.add("Ratan");
        object.add("Raja");
        object.add("Shyam");
        ListIterator<String>iterator = object.listIterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            if(s.equals("Ratan")){
                iterator.set("RajRatan");
            }


        }
        System.out.println(object);
    }
}
