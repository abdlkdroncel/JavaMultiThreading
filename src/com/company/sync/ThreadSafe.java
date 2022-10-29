package com.company.sync;

public class ThreadSafe {

    private int count=0;

    public synchronized void increase(){
        //synchronized -> Until Thread1 has finished, Thread2 cannot start
        count++;
    }

    public void runThreads(){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5000;i++){
                    increase();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5000;i++){
                    increase();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            //
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Count:" +count);
    }

    public static void main(String[] args) {
        ThreadSafe threadSafe=new ThreadSafe();
        threadSafe.runThreads();
    }
}
