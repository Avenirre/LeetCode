package com.topQuestions.easy.trainings;

import java.util.*;

public class ArrayTasks {

    public static void main(String[] args) {

//        int[] arr1 = {1,3,1,2,1,1,1};
//        System.out.println(majorityElement(arr1));
//        int[] arr2 = {1,3,1,2,3,1};
//        System.out.println(uniqueNumberOfOccurences(arr2));
          int[] arr3 = {1,3,2,3,5,6};
        System.out.println(containsDuplicate(arr3));
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
}
