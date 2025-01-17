package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class CursorEx1 {
    public static void main(String[] args) {
        ArrayList<String> obj = new ArrayList<>();
        obj.add("Ratan");
        obj.add("Raja");
        obj.add("Shyam");
        System.out.println("By for each method");
        for (String str:obj) {
            System.out.println(str);

        }
        Iterator itr = obj.iterator();
        System.out.println("By normal Iterator");
        while (itr.hasNext()){
            String st = (String)itr.next();
            System.out.println(st);
        }
        Iterator<String> it = obj.iterator();
        System.out.println("By generic iterator");
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
