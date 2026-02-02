package com.akash.concurrency;

public class SemaphoreMain{
    public static void main(String[] args) {
        SemaphoreResource resource = new SemaphoreResource();

        SemaphoreWorker worker1 = new SemaphoreWorker(resource, "Worker-1");
        SemaphoreWorker worker2 = new SemaphoreWorker(resource, "Worker-2");
        SemaphoreWorker worker3 = new SemaphoreWorker(resource, "Worker-3");
        SemaphoreWorker worker4 = new SemaphoreWorker(resource, "Worker-4");
        SemaphoreWorker worker5 = new SemaphoreWorker(resource, "Worker-5");

        Thread t1 = new Thread(worker1);
        Thread t2 = new Thread(worker2);
        Thread t3 = new Thread(worker3);
        Thread t4 = new Thread(worker4);
        Thread t5 = new Thread(worker5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}