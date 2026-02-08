package com.akash.concurrency;

public class StandardTask implements Runnable {

    private final int taskId;

    public StandardTask(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run(){
        System.out.println("Executing task with ID: " + taskId);

        try {
            Thread.sleep(2000); // Simulate work by sleeping for 2 seconds
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Completed task with ID: " + taskId);
    }
    
}
