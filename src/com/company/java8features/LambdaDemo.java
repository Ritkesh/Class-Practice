package com.company.java8features;

public class LambdaDemo {

    public static void main(String[] args) {
        Employee engineer = ()-> System.out.println("Engineer");
        engineer.getName();
        Employee editor = ()-> System.out.println("Editor");
        editor.getName();
    }
}
