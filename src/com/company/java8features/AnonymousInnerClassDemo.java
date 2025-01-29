package com.company.java8features;

public class AnonymousInnerClassDemo{
    public static void main(String[] args) {
        Person person = new Person(){
            public String getDesignation(){
                return "Engineer";
            }
            public String getSalary(){
                return "100";
            }
        };
        System.out.println(person.getDesignation());
        System.out.println(person.getSalary());
    }
    // when interface is functional interface then we use lambda expression
    // but when there is more than one abstract method in an interface and we don't want to write implementation class
    // then we will use anonymous inner class

}
