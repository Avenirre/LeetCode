package com.topQuestions.easy.trainings.StructuresImpl;

public class MathTasks {

    public static void main(String[] args) {
        //System.out.println(fibonacciNumber(5));
        System.out.println(powerOfTwo(8));
    }

    private static int fibonacciNumber(int n) {
        if (n <= 1) {
            return n;
        }

        int firstNumber = 0;
        int secondNumber = 1;

        for (int i = 2; i <= n; i++) {
            int temp = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
        }

        return secondNumber;
    }

    private static boolean powerOfTwo(int n) {
        if (n < 0 || n % 2 == 1) {
            return false;
        }

        if (n == 1 || n == 2) {
            return true;
        }

        while (n > 2) {
            n /= 2;
            if (n % 2 != 0) {
                return false;
            }
        }

        return n == 2;
    }
}
