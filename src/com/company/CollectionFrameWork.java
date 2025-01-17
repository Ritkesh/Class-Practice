package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionFrameWork {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        Iterator<Integer> valueInteger = intList.iterator();
        while(valueInteger.hasNext()){
            int val = valueInteger.next();
            System.out.println(val);
        }
    }
}
