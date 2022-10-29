package com.company.threadIntro;

public class Printer2 implements Runnable{

    private String name;

    public Printer2(String isim) {
        this.name = isim;
    }
    @Override
    public void run() {
        System.out.println(name+" is working...");
        for (int i=1;i<=10;i++){
            try {
                System.out.println(name+" is writing " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+"is done");
    }
}
