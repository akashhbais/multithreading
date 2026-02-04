package com.akash.concurrency;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 running");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 running");
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Thread 3 running");
        });

        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

    }

}
