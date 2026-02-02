package com.akash.concurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {
    
    int data = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

    public void readData(){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading data: " + data);
            Thread.sleep(1000);
            
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            lock.readLock().unlock();
        }
    }

    public void writeData(int value){
        lock.writeLock().lock();
        try {
            System.out.println("Writing data:"+value);
            data = value;
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            lock.writeLock().unlock();
        }
    }
}
