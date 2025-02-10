package com.company.thread;

public class CreatingThreadUsingRunnable implements Runnable{

    @Override
    public void run(){
        for(int i = 0;i<10;i++){
            System.out.println("world");        }
    }

    public static void main(String[] args) {
        CreatingThreadUsingRunnable t1 = new CreatingThreadUsingRunnable();
        Thread th = new Thread(t1);
        th.run();
    }
}
