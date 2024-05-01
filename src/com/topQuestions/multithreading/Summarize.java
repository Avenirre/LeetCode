package com.topQuestions.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Summarize {

    private static AtomicInteger sum = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(new NumberSum(1, 3));
        Thread t2 = new Thread(new NumberSum(4, 6));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Finished: " + sum.intValue());
    }

    private static final class NumberSum implements Runnable{

        private final int from;
        private final int to;

        public NumberSum(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            IntStream.rangeClosed(from, to).forEach(num -> sum.addAndGet(num));
        }
    }
}
