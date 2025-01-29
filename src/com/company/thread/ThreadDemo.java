package com.company.thread;

public class ThreadDemo implements Runnable{

    private String taskName;
    public ThreadDemo(String taskName){
        this.taskName = taskName;
    }
    public void run(){

        for(int i = 0; i<5;i++){

            System.out.println(taskName +" "+ "is running");

            try{
                Thread.sleep(500);
            } catch(Exception e){
                System.out.println("interrupted");
            }
        }
        System.out.println("Task finished");
    }

    public static void main(String[] args){

        ThreadDemo threadDemo1 = new ThreadDemo("First Task");
        ThreadDemo threadDemo2 = new ThreadDemo("Second Task");
        Thread thread1 = new Thread(threadDemo1);


        Thread thread2 = new Thread(threadDemo2);
        thread1.run();
        thread2.run();
        try {
//            thread1.join();
//            thread2.join();
        }catch(Exception e){
            System.out.println("Error");
        }
        System.out.println("All task has finished");

    }
}
