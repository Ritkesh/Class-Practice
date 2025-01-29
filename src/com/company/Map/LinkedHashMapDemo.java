package com.company.Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[]args){
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();// double linkedList . It maintains the order
        map.put("Apple",30);
        map.put("Guava",40);
        map.put("Banana",80);
        for(Map.Entry<String,Integer>linkedmap:map.entrySet()){
            System.out.println(linkedmap.getKey()+" "+":"+" "+linkedmap.getValue());
        }
        // using accessing order

        System.out.println("using access order false");
        LinkedHashMap<String,Integer> mapAccess =  new LinkedHashMap<String,Integer>(2,0.5f,false);

        mapAccess.put("Ram",98);
        mapAccess.put("Shyam",97);
        mapAccess.put("Krishna",99);
        System.out.println(mapAccess);

        System.out.println("using access order true");
        LinkedHashMap<String,Integer> mapOrder =  new LinkedHashMap<String,Integer>(5,0.5f,true);
        // when access is true it will print recently access element at last. (This concept can be used in least recently used cache called LRU Cache)
        mapOrder.put("A",1);
        mapOrder.put("B",2);
        mapOrder.put("C",3);
        mapOrder.put("D",4);
        mapOrder.put("E",5);
        System.out.println(mapOrder);

        mapOrder.get("C");
        // C will be printed at last because it recently accessed
        System.out.println(mapOrder);

        mapOrder.get("A");
        System.out.println(mapOrder);



    }

}
