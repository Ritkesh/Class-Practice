package com.company;

public class Dog implements AnimalBehaviour{

    private int name;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("Dogs eat Meat and bones");

    }
    public void sleep() {
        System.out.println("Dogs sleep sensibly");

    }
}
