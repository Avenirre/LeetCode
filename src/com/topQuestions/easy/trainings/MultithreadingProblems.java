package com.topQuestions.easy.trainings;

public class MultithreadingProblems {
    int counter = 1;
    static int N;

    public void printNumber(boolean isOdd) {
        synchronized (this) {
            while (counter < N) {
                // If count is odd then print
                while (counter % 2 == (isOdd ? 0 : 1)) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(counter++);
                notify();
            }
        }
    }

    public static void main(String[] args) {
        N = 10;

        MultithreadingProblems mt = new MultithreadingProblems();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                mt.printNumber(false);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                mt.printNumber(true);
            }
        });

        t1.start();
        t2.start();
    }
}


