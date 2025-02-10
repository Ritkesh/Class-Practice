package com.company.thread;

public class CallingMultipleThreads {

    public static void main(String[] args) throws InterruptedException {
        CreatingThreadUsingThread t1 = new CreatingThreadUsingThread();
        CreatingThreadUsingRunnable t2 = new CreatingThreadUsingRunnable();
        Thread th = new Thread(t2);
        t1.start();
        th.start();

    }
}
