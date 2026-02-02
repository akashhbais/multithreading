package com.akash.MultiThreading.controller;

public class MultithreadingLearning extends Thread {

    @Override
    public void run() {
        System.out.println("Code Executed by thread: " + Thread.currentThread().getName());
    }
    
}
