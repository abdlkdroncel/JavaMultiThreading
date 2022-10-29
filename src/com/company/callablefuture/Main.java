package com.company.callablefuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);


        Future<?> future  = executor.submit(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {

                Random random = new Random();

                System.out.println("Thread is working....");

                int x =  random.nextInt(1000) + 2000;

                if (x > 2500){
                    throw new IOException("Thraead didnt worked in x time ...");

                }


                try {
                    Thread.sleep(x);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Thread is done...");

                return x;


            }

        });


        executor.shutdown();

        try {
            System.out.println("Value : " + future.get());
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            System.out.println(ex);
        }

    }

}
