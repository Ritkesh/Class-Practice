package com.company;


enum TestEnum {
    RED,YELLOW,GREEN
}

public class Enum {
    public static void main(String[] args) {
        TestEnum en = TestEnum.GREEN;
        switch (en){
            case RED -> System.out.println("please stop your vehicle and wait for signal to be green");
            case YELLOW -> System.out.println("please slow down your vehicle");
            case GREEN -> System.out.println("please go");
        }
    }
}
