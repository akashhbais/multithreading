package com.akash.MultiThreading.controller;

public class ReaderTask implements Runnable {
    
    private final SharedData data;

    public ReaderTask(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            data.readData();
        }
    }
}
