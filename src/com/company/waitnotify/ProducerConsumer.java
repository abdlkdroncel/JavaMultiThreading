package com.company.waitnotify;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer {

    Random random=new Random();
    Object lock=new Object();
    LinkedList<Integer> queue=new LinkedList<Integer>();
    private int limit=10;

    public void produce(){

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock){
                if(queue.size()==limit){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer value=random.nextInt(100);
                queue.offer(value);
                System.out.println("Producer: "+value);
                lock.notify();
            }
        }

    }

    public void consume(){
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock){
                if(queue.size()==0){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer value=queue.poll();
                System.out.println("Consumer: "+value);
                System.out.println("Size of q: "+queue.size());
                lock.notify();
            }
        }
    }
}
