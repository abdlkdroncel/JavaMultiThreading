package com.company.reentranlock;

public class Main {
    public static void main(String[] args) {
        ReantranLockEx reantranLock=new ReantranLockEx();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                reantranLock.t1Function();
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                reantranLock.t2Function();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reantranLock.exec();
    }
}
