package com.topQuestions.easy.trainings;

import java.util.Arrays;

public class SlidingWindowTrainings {
    public static void main(String[] args) {
//        String needle = "abc";
//        String haystack = "ddfabcde";
//        System.out.println(findTheIndexOfTheFirstOccurenceInAString(needle, haystack));

//        int[] arr1 = {1,2,3,1,4,5};
//        System.out.println(Arrays.toString(containsDuplicateII(arr1, 3)));
        int[] arr2 = {1, 3 ,7 ,2, -4, 0, 9, 2};
        System.out.println(maximumAverageSubarrayI(arr2, 2));
    }

    private static double maximumAverageSubarrayI(int[] arr, int k) {
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }
        int currentSum = maxSum;

        int start = 1;
        int end = k;

        while (end < arr.length) {
            currentSum = currentSum - arr[start - 1] + arr[end];
            maxSum = Math.max(maxSum, currentSum);
            start++;
            end++;
        }

        return (double)maxSum / k;

    }

    private static int[] containsDuplicateII(int[] arr, int k) {
        int i = 0;
        while (i + k < arr.length) {
            if (arr[i] == arr[i + k]) {
                return new int[]{i, i + k};
            }
        }

        return new int[] {-1, -1};
    }

    private static int findTheIndexOfTheFirstOccurenceInAString(String needle, String haystack) {
        int maxNeedleStartIndex = haystack.length() - needle.length();
        for (int i = 0; i <= maxNeedleStartIndex; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int needleIndex = 0;
                while (needleIndex < i + needle.length()) {
                    if (haystack.charAt(i + needleIndex) != needle.charAt(needleIndex++)) {
                        break;
                    }

                    if (needleIndex == needle.length() - 1) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }
}
