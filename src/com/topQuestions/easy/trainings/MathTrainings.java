package com.topQuestions.easy.trainings;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class MathTrainings {

    public static void main(String[] args) {
//        String s1 = "XIV";
//        System.out.println(romanToInteger(s1));

//        int n1 = 8;
//        System.out.println(fibonacciNumber(n1));

//        int[] arr1 = {6, 2, 3, 9};
//        System.out.println(Arrays.toString(plusOne(arr1)));
        String s2 = "456";
        String s3 = "77";
        System.out.println(addStrings(s2, s3));
    }

    private static String addStrings(String s1, String s2) {
        StringBuilder result = new StringBuilder();

        int carry = 0;
        int p1 = s1.length() - 1;
        int p2 = s2.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? s1.charAt(p1--) - '0': 0;
            int x2 = p2 >= 0 ? s2.charAt(p2--) - '0': 0;
            int currentSum = x1 + x2 + carry;
            int value = currentSum % 10;
            carry = currentSum / 10;
            result.append(value);
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
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
