package com.topQuestions.easy.StructuresImpl;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class MathTasks {

    public static void main(String[] args) {
//        System.out.println(fibonacciNumber(5));
//        System.out.println(powerOfTwo(8));
//        int[] arr1 = {9, 9, 9, 9};
//        System.out.println(Arrays.toString(plusOne(arr1)));
        int[][] trust = {new int[]{1,3}, new int[]{2,3}};
        System.out.println(findTheTownJudge(3, trust));

    }

    private static int findTheTownJudge(int n, int[][] trust) {
        if (n != trust.length + 1) {
            return -1;
        }

        int[] trustScores = new int[n + 1];

        for (int[] relation : trust) {
            trustScores[relation[0]]--;
            trustScores[relation[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    private static int[] plusOne(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] == 9) {
                arr[i] = 0;
            } else {
                arr[i]++;
            }
        }

        arr = new int[arr.length + 1];
        arr[0] = 1;

        return arr;
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
}
