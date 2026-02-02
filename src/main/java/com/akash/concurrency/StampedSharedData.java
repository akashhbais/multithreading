package com.akash.concurrency;

import java.util.concurrent.locks.StampedLock;

public class StampedSharedData {
    private int data = 0;
    private final StampedLock stampedLock = new StampedLock();

    public void write() {
    long stamp = stampedLock.writeLock();
    try {
        data++;
        System.out.println("Writing data: " + data);
    } finally {
        stampedLock.unlockWrite(stamp);
    }

    try {
        Thread.sleep(1000); // simulate work OUTSIDE lock
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}

public int read() {
    long stamp = stampedLock.tryOptimisticRead();
    int current = data;

    // simulate delay BEFORE validation
    try {
        Thread.sleep(300);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }

    if (!stampedLock.validate(stamp)) {
        stamp = stampedLock.readLock();
        try {
            current = data;
            System.out.println(Thread.currentThread().getName()
                    + " fallback read: " + current);
        } finally {
            stampedLock.unlockRead(stamp);
        }
    } else {
        System.out.println(Thread.currentThread().getName()
                + " optimistic read: " + current);
    }
    return current;
}

    
}
