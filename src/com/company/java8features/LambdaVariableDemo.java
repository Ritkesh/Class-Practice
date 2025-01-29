package com.company.java8features;

public class LambdaVariableDemo {
    public static void main(String[] args) {
        Employee employee = ()-> System.out.println("Ram");
        employee.getName();
        Employee employee1 = new Employee() {
            public void getName() {
                System.out.println("Krishna");

            }
        };


    }
}
