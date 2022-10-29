package com.company.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // The most two thread can work at same time
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        for(int i=1;i<=5;i++){
            executorService.submit(new Worker(String.valueOf(i),i));
        }

        //another thread will not be assigned
        executorService.shutdown();
        try {
            // max waiting time
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
