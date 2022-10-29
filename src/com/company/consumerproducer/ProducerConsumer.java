package com.company.consumerproducer;

import com.company.sync.ThreadSafe;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    Random random=new Random();

    BlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(10);

    public void produce(){
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Integer value=random.nextInt(100);
                // if size of q is 10, it wait
                queue.put(value);
                System.out.println("Producer is producing :"+value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void consume(){
        while (true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Integer value=queue.take();
                System.out.println("Consumer is consuming");
                System.out.println("Size: "+ queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
