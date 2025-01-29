package com.company.java8features;

public class LambdaVariableDemo2 {
    int y = 9;
    private  void doSomething(){
        int x =5;// local variable
        Employee employee = ()->{
            int p = 10; // local variable

            System.out.println("Hi");
           // x =6; // it will give error that variable should be final
            y = 10; // it will not give error because it is instance variable
        };
        employee.getName();

        Employee employee1 = new Employee() {
            int z = 5;// instance variable
            public void getName() {
                y = 10;
                int z = 13;
                System.out.println(this.z);
                System.out.println("Bye");

            }
        };
        employee1.getName();


    }
}
