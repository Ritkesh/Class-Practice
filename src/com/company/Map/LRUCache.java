package com.company.Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int capacity;

    public LRUCache(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>capacity;
    }

    public static void main(String[] args) {

        LRUCache<String, Integer> studentMap = new LRUCache<>(3);
        studentMap.put("Bob", 99);
        studentMap.put("Alice", 89);
        studentMap.put("Ram", 91);
        // inserting beyond capacity Bob is already present so it will be overwritten and
        // vipul will be added and since Bob is used recently so ALice will be removed
        studentMap.put("Bob", 100);
        studentMap.put("Vipul", 89);


        System.out.println(studentMap);

    }
}
