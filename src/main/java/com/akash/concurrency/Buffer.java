package com.akash.MultiThreading.controller;

public class Buffer {
    
    int buffer[] = new int[5];
    int count = 0;

    synchronized void produce(int value) throws InterruptedException{
        while(count == buffer.length){
            System.out.println("Buffer is full, Producer is waiting...");
            wait();
        }
        buffer[count] = value;
        count++;
        System.out.println("Produced: " + value);
        notifyAll();
    }

    synchronized int consume() throws InterruptedException{
        while(count == 0){
            System.out.println("Buffer is empty, Consumer is waiting...");
            wait();
        }
        int value = buffer[0];
        
        for(int i=0 ; i<count-1 ; i++){
            buffer[i] = buffer[i+1];
        }

        count--;
        System.out.println("Consumed: " + value);
        notifyAll();
        return value;
    }
}
