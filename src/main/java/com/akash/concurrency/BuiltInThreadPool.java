package com.akash.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BuiltInThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("Submitting tasks ...");

        for(int i=1 ; i<=5 ; i++){
            StandardTask task = new StandardTask(i);

            executorService.submit(task);

        }
        executorService.shutdown();
        System.out.println("All tasks submitted.");
    }
}
