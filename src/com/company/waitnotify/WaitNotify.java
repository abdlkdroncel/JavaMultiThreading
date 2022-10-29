package com.company.waitnotify;

import java.util.Scanner;

public class WaitNotify {

    private Object lock=new Object();
    public void t1Function(){

        synchronized (lock){
            System.out.println("Thread1 is working");
            System.out.println("Thread1 is waiting to be awakened by Thread2");

            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1 wake up.Continues");
        }

    }

    public void t2Function(){

        Scanner scanner=new Scanner(System.in);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock){
            System.out.println("Thread2 is working");
            System.out.println("Please enter the key");
            scanner.nextLine();
            lock.notify();
            System.out.println("Completed.");
        }

    }
}
