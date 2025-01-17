package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class CursorEx2 {
    public static void main(String[] args) {
        ArrayList<String> obj = new ArrayList<>();
        obj.add("Ratan");
        obj.add("Raja");
        obj.add("Shyam");
        Iterator<String> iterator = obj.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals("Shyam")){
                iterator.remove();
            }
        }
        System.out.println(obj);
    }
}
