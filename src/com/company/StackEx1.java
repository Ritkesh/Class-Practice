package com.company;

import java.util.Stack;

public class StackEx1 {
    public static void main(String[] args) {
        Stack<String>st = new Stack<String>();
        st.push("ratan");
        st.push("anu");
        st.push("durga");
        st.push("sravya");
        System.out.println(st);
        st.pop();
        System.out.println(st);
        System.out.println(st.search("durga"));
        System.out.println(st.peek());

    }
}
