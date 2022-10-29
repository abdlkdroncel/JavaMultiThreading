package com.company.reentranlock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReantranLockEx {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void toIncrease() {
        for (int i = 0; i < 10000; i++) {
            number++;
        }
    }

    public void t1Function() {
        lock.lock();
        System.out.println("T1 is working");
        System.out.println("T1 waiting to awaken");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("T1 is continuing");
        toIncrease();

        lock.unlock();

    }

    public void t2Function() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner scanner=new Scanner(System.in);

        lock.lock();
        System.out.println("T2 is working");
        toIncrease();
        System.out.println("Press key to continue");
        scanner.nextLine();
        condition.signal();
        System.out.println("done");
        lock.unlock();

    }

    public void exec() {
        System.out.println("Number :" + number);
    }
}
