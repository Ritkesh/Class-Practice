package com.company.Map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // creating a hash map
        System.out.println("creating a hash map");
        HashMap<Integer,String> map = new HashMap<>();
      //  adding data in hash map
        map.put(1,"Akshit");
        map.put(2,"Neha");
        map.put(3,"Shubham");
        System.out.println("printing map");
        System.out.println(map);
        // get value using key
        System.out.println("get value using key");
        System.out.println(map.get(1));
        System.out.println(map.get(5));

        //check key by using containskey
        System.out.println("check key by using containskey");
        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(4));
        // check value by using containsValue
        System.out.println("check value by using containsValue");
        System.out.println(map.containsValue("Shubham"));
        System.out.println(map.containsValue("Nick"));

        // loop in hashmap
        // printing value only
        System.out.println("loop to print value only");
        for (int i:map.keySet()) {
            System.out.println(map.get(i));
        }
        // loop to print key and value both
        System.out.println("loop to print key and value both");
        for (Map.Entry<Integer,String> entry:map.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
        System.out.println("changing values to upper case");
        for (Map.Entry<Integer,String> entry:map.entrySet()) {
            entry.setValue(entry.getValue().toUpperCase());
        }
        System.out.println(map);

        // removing entry by using key
        System.out.println("removing entry by using key");
        map.remove(1);
        System.out.println(map);
        // removing entry by using key,value both
        System.out.println("removing entry by using key,value both");
        map.remove(2,"NEHA");
        System.out.println(map);
    }
}
