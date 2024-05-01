package com.topQuestions.multithreading.simple;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        /**
         * It prints "I'm main thread" only in many cases
         *
         * #2 will not be printed because all daemon thread will die after interrupting of main thread
         */
        System.out.println("I'm main thread");

        Thread t = new Thread(()-> System.out.println("I'm alive"));
        t.setDaemon(true);
        t.start();
        // Let's destroy main thread
        Thread.currentThread().interrupt();
    }
}
