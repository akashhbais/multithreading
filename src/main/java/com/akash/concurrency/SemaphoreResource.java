package com.akash.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreResource {

    private final Semaphore semaphore = new Semaphore(3);

    public void accessResource(String name) throws InterruptedException {
        try {
            semaphore.acquire();
            System.out.println("Resource accessed by " + name);
            Thread.sleep(2000); // Simulate resource access
            System.out.println("Resource released by " + name);
        } catch (Exception e) {
            // handle 
        }finally{
            semaphore.release();
        }
    }
    
}
