package com.akash.concurrency;

public class MonitorLockMain {

    public static void main(String[] args) {

        MonitorLockExample obj = new MonitorLockExample();

        MonitorThread1Runnable runnable = new MonitorThread1Runnable(obj);
        
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();

        // MultithreadingLearning thread1 = new MultithreadingLearning();
        // thread1.start();
        // System.out.println("Main Thread Executing: " + Thread.currentThread().getName());

    }
}
