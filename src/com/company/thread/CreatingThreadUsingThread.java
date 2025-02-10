package com.company.thread;

public class CreatingThreadUsingThread extends Thread {

    @Override
    public void run(){
        for (int i = 0;i<10;i++){
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) {
        CreatingThreadUsingThread t = new CreatingThreadUsingThread();
        t.start();
    }
}
