package com.topQuestions.easy.trainings;

import java.util.*;

public class ArrayTasks {

    public static void main(String[] args) {

//        int[] arr1 = {7,2,8,5,1,3,4};
//        System.out.println(missingNumber(arr1));
//        int[] arr2 = {1,3,1,2,1,1,1};
//        System.out.println(majorityElement(arr1));
//        int[] arr3 = {1,3,1,2,3,1};
//        System.out.println(uniqueNumberOfOccurences(arr2));
//        int[] arr4 = {1,3,2,3,5,6};
//        System.out.println(containsDuplicate(arr3));
//        int[] arr5 = {1, 1, 2, 2, 3, 3, 3, 3, 3};
//        System.out.println(elementAppearingMoreThan25PercentInSortedArray(arr4));
//        int[] arr6 = {1,2,3,3,5,6};
//        System.out.println(setMismatch(arr5));
        int[] arr7 = {1,2,3,4};
        System.out.println(Arrays.toString(runningSumOf1DArray(arr7)));
    }

    private static int missingNumber(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] > 1) {
                return arr[i] + 1;
            }
        }

        return -1;
    }


    private static int majorityElement(int[] arr) {
        Map<Integer, Integer> stats = new HashMap<>();

        for (int el: arr) {
            int currentFrequency = stats.getOrDefault(el, 0);

            if (currentFrequency + 1 > arr.length / 2) {
                return el;
            } else {
                stats.put(el, currentFrequency + 1);
            }
        }

        return -1;
    }

    private static boolean uniqueNumberOfOccurences(int[] arr) {
        Map<Integer, Integer> stats = new HashMap<>();

        for (int el: arr) {
            stats.put(el, stats.getOrDefault(el, 0) + 1);
        }

        Set<Integer> frequencies = new HashSet<>(stats.values());

        return frequencies.size() == stats.values().size();
    }

    private static boolean containsDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();

        for (int el: arr) {
            if (!set.add(el)) {
                return true;
            }
        }

//        Arrays.sort(arr);
//        for (int i = 0; i < arr.length - 1; ++i) {
//            if (arr[i] == arr[i + 1]) return true;
//        }

        return false;
    }


    private static int elementAppearingMoreThan25PercentInSortedArray(int[] arr) {
        int numberOfMajorOccurences = arr.length / 4;

        for (int i = 0; i < arr.length - numberOfMajorOccurences; i++) {
            if (arr[i] == arr[i + numberOfMajorOccurences]) {
                return arr[i];
            }
        }
        return -1;
    }

    //TO DO
    private static int[] setMismatch(int[] arr) {
        int[] results = new int[2];

        if (arr[0] != 1 || arr.length == 2) {
            return new int[] {2, 1};
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {

                results[0] = arr[i - 1];
                results[1] = arr[i - 1] + 1;
            }
        }

        System.out.println(Arrays.toString(results));
        return results;
    }

    private static int[] runningSumOf1DArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }


}
