package com.topQuestions.multithreading.dirtyClean;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CleanReadingWritingObjectValueWithLock {

    public static Integer counter = 0;
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    lock.lock();  // #1
                    counter++;
                    lock.unlock();// #2
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    lock.lock();  // #3
                    counter--;
                    lock.unlock();// #4

                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter = " + counter);
    }
}
