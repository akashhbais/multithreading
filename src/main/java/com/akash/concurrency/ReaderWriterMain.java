package com.akash.concurrency;

public class ReaderWriterMain {
    
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread writerThread = new Thread(new WriterTask(sharedData), "Writer-1");
        Thread readerThread1 = new Thread(new ReaderTask(sharedData), "Reader-1");
        Thread readerThread2 = new Thread(new ReaderTask(sharedData), "Reader-2");
        Thread readerThread3 = new Thread(new ReaderTask(sharedData), "Reader-3");

        writerThread.start();
        readerThread1.start();
        readerThread2.start();
        readerThread3.start();
    }


}
