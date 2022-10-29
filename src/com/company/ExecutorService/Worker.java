package com.company.ExecutorService;

public class Worker implements Runnable{
    private String name;
    private int taskId;

    public Worker(String name, int taskId) {
        this.name = name;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Worker "+ name +" " + taskId +" is started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker "+ name +" " + taskId +" is done ");
    }
}
