package com.akash.concurrency;

public class StampedReaderWorker implements Runnable{
    private final StampedSharedData data;

    public StampedReaderWorker(StampedSharedData data){
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int val = data.read();
            System.out.println(Thread.currentThread().getName() +
                    " read value: " + val);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
