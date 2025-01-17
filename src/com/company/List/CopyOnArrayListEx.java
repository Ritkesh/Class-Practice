package com.company.List;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnArrayListEx {
    public static void main(String[] args) {
        // we trying to perform reading and writing in a list concurrently
        // it will give concurrentModificationException

//        List<String>shoppingList = new ArrayList<>();
//        shoppingList.add("Milk");
//        shoppingList.add("Egg");
//        shoppingList.add("Bread");
//        for (String item:shoppingList) {
//            System.out.println(item);
//            if(item.equals("Egg")){
//                shoppingList.add("Butter");
//            }
//        }
//        System.out.println(shoppingList);


        List<String>shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Egg");
        shoppingList.add("Bread");
        for (String item:shoppingList) {
            System.out.println(item);
            if(item.equals("Egg")){
                shoppingList.add("Butter");
                System.out.println("added butter while reading");
            }
        }
        System.out.println("updated list");
        System.out.println(shoppingList);
    }
}
