package com.akash.concurrency;

public class LockTest {
    public static void main(String[] args) {
        Object lock = new Object();

        // Thread 1: Uses sleep()
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 1: Holding lock & Sleeping...");
                try { Thread.sleep(2000); } catch (Exception e) {}
                System.out.println("Thread 1: Woke up & Done.");
            }
        }).start();

        // Thread 2: Uses wait()
        // This thread tries to get the lock.
        // Since Thread 1 uses sleep (holds lock), Thread 2 CANNOT start until Thread 1 finishes.
        new Thread(() -> {
            try { Thread.sleep(100); } catch (Exception e) {} // Ensure T1 starts first
            synchronized (lock) {
                System.out.println("Thread 2: I got the lock! (T1 must have released it)");
            }
        }).start();
    }
}