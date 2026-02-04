package com.akash.concurrency;

public class DaemonThread {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() ->{
            while(true){
                System.out.println("Daemon Thread is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Handle any interruption
                }
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("Main Thread is running...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            //handle any interruption
        }
        System.out.println("Main Thread is exiting...");

        /* Daemon thread will automatically terminate when the main thread exits */
    }
}
