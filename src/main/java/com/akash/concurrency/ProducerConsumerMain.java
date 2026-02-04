package com.akash.concurrency;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerMain {
    
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

    Producer producer = new Producer(buffer);
    Consumer consumer = new Consumer(buffer);

    Thread t1 = new Thread(producer);
    Thread t2 = new Thread(consumer);

    t1.start();
    t2.start();

    AtomicInteger at = new AtomicInteger();
    AtomicBoolean ab = new AtomicBoolean(true);

    }

}
