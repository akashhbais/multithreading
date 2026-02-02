package com.akash.MultiThreading.controller;

public class MonitorLockExample {

    // Method-level synchronization (locks on 'this')
    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " ENTERED method1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " EXITING method1");
    }

    // Block-level synchronization (fine-grained lock)
    public void method2() {
        System.out.println(Thread.currentThread().getName() + " BEFORE lock in method2");

        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " INSIDE lock in method2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " AFTER lock in method2");
    }

    // No synchronization
    public void method3() {
        System.out.println(Thread.currentThread().getName() + " executing method3 (NO LOCK)");
    }
}
