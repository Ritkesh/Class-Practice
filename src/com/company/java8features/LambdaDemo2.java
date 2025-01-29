package com.company.java8features;
class MyClass implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<10;i++){
            System.out.println("Hello");
        }
    }
}

public class LambdaDemo2 {
    public static void main(String[] args) {
        System.out.println("using implementation class");
        MyClass myClass = new MyClass();
        Thread thread = new Thread(myClass);
        thread.run();
        System.out.println("using lambda expression");

        Runnable runnable = ()->{
            for(int i =0;i<10;i++){
                System.out.println("Bye");
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.run();
    }
}
