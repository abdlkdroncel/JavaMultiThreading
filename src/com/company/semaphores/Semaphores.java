package com.company.semaphores;

import java.util.concurrent.Semaphore;

public class Semaphores {
    //at same time 3 thread
    private Semaphore semaphore=new Semaphore(3);

    public void threadFunction(int id) {
        try {
            semaphore.acquire();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread is starting id: "+id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done :"+id);

        semaphore.release();
    }
}
