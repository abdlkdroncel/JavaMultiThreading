package com.company.semaphores;

public class Main {
    public static void main(String[] args) {
        Semaphores semaphores=new Semaphores();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                semaphores.threadFunction(1);
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                semaphores.threadFunction(2);
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                semaphores.threadFunction(3);
            }
        });
        Thread t4=new Thread(new Runnable() {
            @Override
            public void run() {
                semaphores.threadFunction(4);
            }
        });
        Thread t5=new Thread(new Runnable() {
            @Override
            public void run() {
                semaphores.threadFunction(5);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
