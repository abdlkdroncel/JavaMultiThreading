package com.company.threadIntro;

public class Printer extends Thread{

    private String name;

    public Printer(String isim) {
        this.name = isim;
    }

    // we make override for PrinterClass to behave thread like Thread
    @Override
    public void run() {
        System.out.println(name+"is working...");
        for (int i=1;i<=10;i++){
            try {
                System.out.println(name+" is writing " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+" is completed");
    }
}
