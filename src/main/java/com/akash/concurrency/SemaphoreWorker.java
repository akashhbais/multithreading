package com.akash.concurrency;

public class SemaphoreWorker implements Runnable{

    private final SemaphoreResource resource;
    private final String name;

    public SemaphoreWorker(SemaphoreResource resource, String name){
        this.resource = resource;
        this.name = name;
    }

    @Override
    public void run(){
        try {
            resource.accessResource(name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
