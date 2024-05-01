package com.topQuestions.multithreading.dirtyClean;

import java.util.concurrent.atomic.AtomicInteger;

public class CleanReadingWritingAtomicInteger {
    public static AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++)
                    counter.incrementAndGet();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++)
                    counter.decrementAndGet();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter = " + counter);

    }
}
