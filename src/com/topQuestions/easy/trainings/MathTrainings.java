package com.topQuestions.easy.trainings;

import java.util.Arrays;

public class MathTrainings {

    public static void main(String[] args) {
//        String s1 = "XIV";
//        System.out.println(romanToInteger(s1));

//        int n1 = 8;
//        System.out.println(fibonacciNumber(n1));

        int[] arr1 = {6, 2, 3, 9};
        System.out.println(Arrays.toString(plusOne(arr1)));
    }

    private static int[] plusOne(int[] arr) {
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] != 9) {
                arr[i]++;
                return arr;
            } else {
                arr[i] = 0;
            }
        }
        int[] result = new int[arr.length + 1];
        result[0] = 1;

        return result;
    }

    private static int fibonacciNumber(int n) {
        //0 1 1 2 3 5 8 13
        int prev = 0;
        int current = 1;

        for (int i = 2; i <= n - 1 ; i++) {
            int temp = current;
            current += prev;
            prev = temp;
        }

        return current;
    }

    private static int romanToInteger(String s) {
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentNumber = 0;

            switch(s.charAt(i)) {
                case 'I':
                    currentNumber = 1;
                    break;
                case 'V':
                    currentNumber = 5;
                    break;
                case 'X':
                    currentNumber = 10;
                    break;
                case 'L':
                    currentNumber = 50;
                    break;
                case 'C':
                    currentNumber = 100;
                    break;
                case 'M':
                    currentNumber = 1000;
                    break;
            }
            if (result > currentNumber * 4) {
                result -= currentNumber;
            } else {
                result += currentNumber;
            }

        }

        return result;
    }
}
