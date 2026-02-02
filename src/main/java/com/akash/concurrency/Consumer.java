package com.akash.MultiThreading.controller;

public class Consumer implements Runnable{
    
    Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer=buffer;
    }

    @Override
    public void run() {
        try {
            while(true){
                buffer.consume();
                System.out.println("Consumer Thread Executing: " + Thread.currentThread().getName());
                Thread.sleep(1000); 
            }
        } catch (Exception e) {
        }
        
    }

    
}
