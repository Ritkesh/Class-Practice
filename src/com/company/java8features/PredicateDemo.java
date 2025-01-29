package com.company.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {

        // prdeicate returns the boolean value , itv always checks the condition
        Predicate<Integer> integerPredicate = x-> x>10;
        int y = 11;
        int z = 9;
        System.out.println(integerPredicate.test(y));
        System.out.println(integerPredicate.test(z));

        Predicate<Integer> evenPredicate = x->x%2 == 0;
        List<Integer> number = Arrays.asList(1,4,3,7,8,3,45,98);

        int sum = 0;

        for(int i = 0;i<number.size();i++){

            if(evenPredicate.test(number.get(i))){

                sum = sum + number.get(i);
            }

        }
        System.out.println(sum);

        Predicate<String> stringPredicateStartsWith = x-> x.toLowerCase().charAt(0) == 'r';
        Predicate<String> stringPredicateEndsWith = x-> x.toLowerCase().charAt(x.length()-1) == 'h';
        Predicate<String> andPredicate = stringPredicateStartsWith.and(stringPredicateEndsWith);
        System.out.println(andPredicate.test("Ritkesh"));
        System.out.println(andPredicate.test("raja"));

    }
}
