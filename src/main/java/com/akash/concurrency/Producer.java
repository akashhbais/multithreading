package com.akash.concurrency;

class Producer implements Runnable {

    Buffer buffer;
    int value = 0;

    public Producer(Buffer buffer){
        this.buffer=buffer;
    }

    @Override
    public void run() {
        try {
            while(true){
                buffer.produce(value);
                value++;
                System.out.println("Producer Thread Executing: " + Thread.currentThread().getName());
                Thread.sleep(500);
            }
        } catch (Exception e) {
        }
    }

    
}