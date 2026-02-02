package com.akash.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable{
    
    private static final ReentrantLock lock = new ReentrantLock();
    private final String task;

    public ReentrantLockDemo(String task){
        this.task = task;
    }


      @Override
    public void run() {

        System.out.println(task + " trying to acquire lock");

        lock.lock();   // enter critical section
        try {
            System.out.println(task + " ENTERED critical section");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        } finally {
            lock.unlock(); // MUST unlock
            System.out.println(task + " EXITED critical section");
        }
    }

    public static void main(String[] args) {

        ReentrantLockDemo task1 = new ReentrantLockDemo("Thread-1");
        ReentrantLockDemo task2 = new ReentrantLockDemo("Thread-2");
        ReentrantLockDemo task3 = new ReentrantLockDemo("Thread-3");

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
    }
}
