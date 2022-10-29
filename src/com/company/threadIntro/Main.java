package com.company.threadIntro;

public class Main {

    public static void main(String[] args) {
       /* Printer printer1=new Printer("P1");
        Printer printer2=new Printer("P2");

        printer1.start();
        printer2.start();*/

        /*
        Thread printer1=new Thread(new Printer2("p1"));
        Thread printer2=new Thread(new Printer2("p2"));

        printer1.start();
        printer2.start();*/

        /*
        Thread printer1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("first is working...");
                for (int i=1;i<=10;i++){
                    try {
                        System.out.println("first is writing " + i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("first is done");
            }
        });

        printer1.start();

        */

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("second is working...");
                for (int i=1;i<=10;i++){
                    try {
                        System.out.println(" writing " + i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("second is done");
            }
        }).start();


    }
}
