package com.akash.concurrency;
public class ThreadJoining {
    public static void main(String[] args) {
        Thread downloadThread = new Thread(() -> {
            System.out.println("Downloading file...");
            try {
                Thread.sleep(3000);
                
            } catch (InterruptedException e) {
            }
            System.out.println("File downloaded.");
        });

        downloadThread.start();
        
        System.out.println("Main thread waiting for download...");
        try {
            downloadThread.join();
        } catch (InterruptedException e) {

        }

        System.out.println("Processing downloaded file...");


    }
}
