package com.company;

import java.util.ArrayList;
import java.util.Vector;

public class VectorEx1 {
    public static void main(String[] args) {
        Vector<String> obj = new Vector<>();
        obj.add("ratan");
        obj.add("raja");
        System.out.println(obj.capacity());//default capacity is 10
        System.out.println("******");
        Vector<String>objs = new Vector<>(3);
        objs.add("ratan");
        objs.add("raja");
        objs.add("ram");
        objs.add("shyam");
        System.out.println(objs.capacity());//capacity become doubles of the initial capacity
        System.out.println("*****");

        Vector<String>ob = new Vector<>(2,6);
        System.out.println(ob.capacity());
        ob.add("raja");
        ob.add("ratan");
        ob.add("shyam");
        System.out.println(ob.capacity());
        ob.add("1");
        ob.add("2");
        ob.add("3");
        ob.add("4");
        ob.add("5");
        ob.add("6");
        System.out.println(ob.capacity());
        System.out.println("****");
        ArrayList<String> al = new ArrayList<String>();
        al.add("ratan");
        Vector<String> v = new Vector<String>(al);
        v.add("anu");
        System.out.println(v);
    }
}
