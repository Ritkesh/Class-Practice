package com.company.Map;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {

    public static void main(String[] args) {
        String key1 = new String("key");
        String key2 = new String("key");
        Map<String,Integer>map = new HashMap<>();
        map.put(key1,1);
        map.put(key2,2);
        System.out.println(map);

        Map<String,Integer> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(key1,1);
        identityHashMap.put(key2,2);
        System.out.println(identityHashMap);


        // in identity hashmap hashcode method of object is used not the hashcode method of that class
        // but in hashMap hashcode method of class is used.

        // in identityHashMap to calculate hashcode we use System.identityHashCode()
        System.out.println("hashcode in identityHashMap");
        System.out.println(System.identityHashCode(key1));
        System.out.println(System.identityHashCode(key2));
        System.out.println("hashcode in hashmap");
        System.out.println(key1.hashCode());
        System.out.println(key2.hashCode());

        // in identityHashMap hashCode is different, so it is printing both value and its size is 2
        // while in hashMap hashCode is same , so iti is printing same value and its size is 1

    }
}
