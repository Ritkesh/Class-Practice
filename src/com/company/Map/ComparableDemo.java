package com.company.Map;

import com.company.Student;

import java.util.ArrayList;
import java.util.List;

public class ComparableDemo {

    public static void main(String[] args) {
        List<Student> st = new ArrayList<>();
        st.add(new Student("Ram",78.5));
        st.add(new Student("Shyam",76.0));
        st.add(new Student("Ram",75.0));
        st.add(new Student("Ram",98.7));
        st.add(new Student("Ram",87.5));

        st.sort(null);
        System.out.println(st.toString());


    }
}
