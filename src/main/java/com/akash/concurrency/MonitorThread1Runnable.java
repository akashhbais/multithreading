package com.akash.MultiThreading.controller;

public class MonitorThread1Runnable implements Runnable {

    private final MonitorLockExample monitorLockExample;

    public MonitorThread1Runnable(MonitorLockExample monitorLockExample) {
        this.monitorLockExample = monitorLockExample;
    }

    @Override
    public void run() {
        monitorLockExample.method1();
        monitorLockExample.method2();
        monitorLockExample.method3();
    }
}
