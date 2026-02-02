package com.akash.concurrency;

public class StampedWriterWorker implements Runnable{
    private final StampedSharedData data;

    public StampedWriterWorker(StampedSharedData data){
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            data.write();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}