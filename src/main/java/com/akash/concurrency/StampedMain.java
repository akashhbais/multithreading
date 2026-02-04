package com.akash.concurrency;

public class StampedMain {
    
    public static void main(String[] args) {
        StampedSharedData data = new StampedSharedData();
  

        Thread writerThread = new Thread(new StampedWriterWorker(data), "Stamped-Writer");
        Thread readerThread1 = new Thread(new StampedReaderWorker(data), "Stamped-Reader-1");
        Thread readerThread2 = new Thread(new StampedReaderWorker(data), "Stamped-Reader-2");
        Thread readerThread3 = new Thread(new StampedReaderWorker(data), "Stamped-Reader-3");

        writerThread.start();
        readerThread1.start();
        readerThread2.start();
        readerThread3.start();
        
    }

}
