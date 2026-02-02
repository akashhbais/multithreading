package com.akash.concurrency;

public class WriterTask implements Runnable{
    
    
    private final SharedData data;
    int value = 0;

    public WriterTask(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            data.writeData(++value);
        }
    }

}
