package com.company.java8features;

import com.company.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaDemo3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(39);
        list.add(87);
        list.add(78);
        list.add(56);
        list.add(74);
        list.add(99);
        //for natural sorting
        System.out.println("natural sorting");
        list.sort(null);
        System.out.println(list);

        List<Integer> list1 = new ArrayList<>();
        list1.add(39);
        list1.add(87);
        list1.add(78);
        list1.add(56);
        list1.add(74);
        list1.add(99);

        //by using lambda expression for sorting in descending order

        System.out.println("customize sorting using lambda expression");

        list1.sort((a,b)-> b-a);
        System.out.println(list1);


        List<Student> st = new ArrayList<>();
        st.add(new Student("Ram",98d));
        st.add(new Student("Shyam",75d));
        st.add(new Student("Shivam",97.5));
        st.add(new Student("Murali",88d));
        st.add(new Student("Neha",89d));
        st.add(new Student("Radha",95.78));

        st.sort((a,b)->Double.compare(b.getGpa(), a.getGpa()));
        System.out.println(st);


    }
}
