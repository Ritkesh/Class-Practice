package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class InfiniteLoop {
    public static void main(String[] args) {
        int i = 0;
//       while (true){
//           System.out.println("HI");
//       }

        Map<Integer,String> map  =  Map.of(111,"Ratan",222,"Raja");
        map.forEach((k,v)-> System.out.println(k +":"+v));
        TreeMap<Integer,String> tree = new TreeMap<>();
        tree.put(88,"Raja");
        tree.put(76,"Ratan");
        tree.forEach((k,v)-> System.out.println(k +":"+v));
        TreeMap<Integer,String> tree1 = new TreeMap<>((i1,i2)->-i1.compareTo(i2));
        tree1.put(88,"Raja");
        tree1.put(76,"Ratan");
        tree1.forEach((k,v)-> System.out.println(k +":"+v));

        List<Integer> number = List.of(2,3,5,7,9,11,12,14,12);
        number.stream()
                .filter(x->x%2 ==0)
                .forEach(p-> System.out.println(p));

       List<Integer>evenNumber =  number.stream()
                .filter(x->x%2 ==0)
                .collect(Collectors.toList());
        System.out.println(evenNumber);
        Set<Integer> setEvenumber = number.stream()
                .filter(x->x%2 ==0)
                .collect(Collectors.toSet());
        System.out.println(setEvenumber);

        number.stream()
                .map(x->x+2)
                .forEach(y-> System.out.println(y));

        int sum  =  number.stream()
                .map(x->x+2)
                .mapToInt(x->x)
                .sum();
        System.out.println(sum);

    }
}
