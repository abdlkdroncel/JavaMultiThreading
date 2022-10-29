package com.company.waitnotify;

public class Main {
    public static void main(String[] args) {
        /*WaitNotify wn=new WaitNotify();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                wn.t1Function();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                wn.t2Function();
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

         */

        ProducerConsumer producerConsumer=new ProducerConsumer();

        Thread producer=new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.produce();
            }
        });

        Thread consume=new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.consume();
            }
        });

        producer.start();
        consume.start();

        try {
            producer.join();
            consume.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
