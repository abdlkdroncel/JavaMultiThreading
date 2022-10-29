package com.company.syncsolution;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListWorker {

    Random random = new Random();
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    ArrayList<Integer> list2 = new ArrayList<Integer>();

    private Object lock1 = new Object();
    private Object lock2 = new Object();


    public  void addToList1(){

        synchronized(lock1) {

            try {
                Thread.sleep(1);


            } catch (InterruptedException ex) {
                Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            list1.add(random.nextInt(100));
        }


    }
    public  void addToList2(){

        synchronized(lock2){
            try {
                Thread.sleep(1);


            } catch (InterruptedException ex) {
                Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            list2.add(random.nextInt(100));
        }

    }
    public void assignToValue(){

        for (int i = 0 ; i < 1000 ; i++) {
            addToList1();
            addToList2();

        }

    }
    public void working(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                assignToValue();

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                assignToValue();

            }
        });
        long starting = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ListWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("List1 Size :" + list1.size() + " List2 Size: " + list2.size());

        long ending =  System.currentTimeMillis();

        System.out.println("The passing time : " + (ending - starting));


    }
}
