package com.topQuestions.multithreading;

public class OddEvenNumber {

    public static void main(String[] args) {
        SharedCounter counter = new SharedCounter();

        ThreadPrintingNums oddThread = new ThreadPrintingNums("OddThread", counter, false, 10);
        ThreadPrintingNums evenThread = new ThreadPrintingNums("EvenThread",counter, true, 10);
        System.out.println("Starting Threads");

        oddThread.start();
        evenThread.start();
    }

    static class ThreadPrintingNums extends Thread {

        private SharedCounter counter;
        private boolean flagPrintEven;
        private int max;

        public ThreadPrintingNums(String threadName, SharedCounter obj, boolean flagPrintEven, int max) {
            setName(threadName);
            this.counter = obj;
            this.flagPrintEven = flagPrintEven;
            this.max = max;
        }

        @Override
        public void run() {
            while (counter.getCounter() <= max) {
                if (counter.getCounter() % 2 == (flagPrintEven ? 0 : 1)) {
                    System.out.printf("%s => %d%n", getName(), counter.getCounter());
                    counter.incCounter();
                } else {
                    try {
                        synchronized (counter) {
                            counter.wait();
                        }
                    } catch (InterruptedException e) {
                        System.out.printf("%s interrupted exception", getName());
                        System.exit(-1);
                    }
                }
            }
        }
    }

    static class SharedCounter {

        private int counter;

        public SharedCounter() {
            this.counter = 1;
        }

        public synchronized int getCounter() {
            return counter;
        }

        public synchronized void incCounter() {
            counter++;
            notify();
        }
    }
}
