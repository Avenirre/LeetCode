package com.topQuestions.trainings;

public class SlidingWindowTasks {

    public static void main(String[] args) {
//        String needle = "abc";
//        String haystack = "dbbabcfe";
//        findTheIndexOfTheFirstOccurenceInAString(needle, haystack);
//        int[] arr1 = {1,2,3,1,5,6};
//        System.out.println(containsDuplicateII(arr1, 3));
//        int arr2[] = {1,2,3,4,5,6};
//        System.out.println(maximumAverageSubarrayI(arr2, 3));

    }

    private static double maximumAverageSubarrayI(int[] arr, int k) {
        int diff = arr.length - k;

        int result = 0;
        for (int i = 0; i < k; i++) {
            result += arr[i];
        }

        for (int i = 1; i <= diff; i++) {
            int currentSum = result - arr[i - 1] + arr[i + k - 1];
            if (currentSum > result) {
                result = currentSum;
            }
        }

        return (double)result / k;
    }


    private static int findTheIndexOfTheFirstOccurenceInAString(String needle, String haystack) {

        if (needle.length() == 0) {
            return 0;
        }

        if (haystack.length() == 0) {
            return -1;
        }

        int lengthsDiff = haystack.length() - needle.length();
        int firstLetter = needle.charAt(0);

        for (int i = 0; i <= lengthsDiff; i++) {
            if (haystack.charAt(i) == firstLetter) {
                int j = 0;
                while (j < needle.length()) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    j++;
                }

                if (j == needle.length()) {
                    System.out.println(i);
                    return i;
                }

            }
//            for (int j = 0; j < needle.length(); j++) {
//                if (haystack.charAt(i + j) != needle.charAt(j)) {
//                    break;
//                }
//
//                if (j == needle.length() - 1) {
//                    System.out.println(i);
//                    return i;
//                }
//            }
        }

        System.out.println("-1");
        return -1;
    }

    private static boolean containsDuplicateII(int[] arr, int k) {
        int diff = arr.length - k;

        for (int i = 0; i < diff; i++) {
            if (arr[i] == arr[i + k]) {
                return true;
            }
        }

        return false;
    }
}
