package com.topQuestions.easy.trainings;

import java.util.*;
import java.util.stream.Collectors;

public class ArraysTrainings {
    public static void main(String[] args) {
//        int[] arr1 = {1,3,8,2,6};
//        System.out.println(Arrays.toString(twoSum(arr1, 8)));

//        String[] arr2 = {"flower","flow","flight"};
//        System.out.println(longestCommonPrefix(arr2));

//        int[] arr3 = {0, 1, 2, 4, 5};
//        System.out.println(missingNumber(arr3));
//        int[] arr4 = {1, 5, 1 ,3, 2, 1, 1};
//        System.out.println(majorityElements(arr4));

//        int[] arr5 = {1, 2, 2, 2, 3, 3, 3};
//        System.out.println(uniqueNumberOfOccurences(arr5));

//        int[] arr6 = {1, 2, 2, 2, 3,};
//        System.out.println(elementAppearingMoreThan25PercentInSortedArray(arr6));

//        int[] arr7 = {1, 2, 3 ,4 ,5};
//        System.out.println(Arrays.toString(runningSumOf1dArray(arr7)));

//        int[] arr8 = {1, 1, 2, 2, 3 ,4, 4, 5, 5};
//        System.out.println(singleNumber(arr8));

//        int[] arr9 = {1, 2, 3, 6};
//        int[] arr10 = {2, 3, 4, 5};
//        System.out.println(minimumCommonValue(arr9, arr10));

        int[] arr11 = {1,2,2,3,1,4};
        System.out.println(maxFrequencyElements(arr11));

    }

    public static int maxFrequencyElements(int[] arr) {
        int[] maxFrequency = {0};
        Map<Integer, Integer> stats = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int currentFrequency = stats.getOrDefault(arr[i], 0) + 1;
            stats.put(arr[i], currentFrequency);
            maxFrequency[0] = Math.max(maxFrequency[0], currentFrequency);
        }

        return stats.entrySet().stream().filter(e -> e.getValue() == maxFrequency[0])
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    private static int minimumCommonValue(int[] arr1, int[] arr2) {
        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < arr1.length && pointer2 < arr2.length) {
            if (arr1[pointer1] < arr2[pointer2]) {
                pointer1++;
            } else if (arr1[pointer1] > arr2[pointer2]) {
                pointer2++;
            } else {
                return arr1[pointer1];
            }
        }

        return -1;
    }

    private static int singleNumber(int[] arr) {
        Set<Integer> uniqueElements = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        int arrSum = Arrays.stream(arr).sum();

        int setSum = uniqueElements.stream().mapToInt(Integer::intValue).sum();

        return setSum * 2 - arrSum;
    }

    private static int[] runningSumOf1dArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }

        return arr;
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

    private static boolean uniqueNumberOfOccurences(int[] arr) {
        Map<Integer, Integer> stats = new HashMap<>();

        Arrays.stream(arr).forEach(el -> stats.put(el, stats.getOrDefault(el, 0) + 1));

        Set<Integer> frequencies = new HashSet<>();
        for (int fr: stats.values()) {
            if (!frequencies.add(fr)) {
                return false;
            }
        }

        return true;
    }

    private static int majorityElements(int[] arr) {
        Map<Integer, Integer> stats = new HashMap<>();

        Arrays.stream(arr).forEach(el -> stats.put(el, stats.getOrDefault(el, 0) + 1));

        return stats.entrySet().stream().filter(e -> e.getValue() > arr.length / 2).findFirst().get().getKey();
    }

    private static int missingNumber(int[] arr) {
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        for (int j = 0; j < arr.length; j++) {
            if (!set.contains(j)) {
                return j;
            }
        }

        return -1;
    }

    private static String longestCommonPrefix(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }

        if (arr.length == 1) {
            return arr[0];
        }

        String commonPrefix = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int shorterLength = commonPrefix.length() <= arr[i].length() ? commonPrefix.length() : arr[i].length();

            for (int j = 0; j < shorterLength; j++) {
                if (commonPrefix.charAt(j) != arr[i].charAt(j)) {
                    commonPrefix = commonPrefix.substring(0, j);
                    break;
                }
                commonPrefix = commonPrefix.substring(0, shorterLength);
            }
        }

        return commonPrefix;
    }

    private static int[] twoSum(int[] arr, int target) {
        // [7 0], [5 1], [0 2], [6 3], [6 4]
        Map<Integer, Integer> diffs = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (diffs.containsKey(arr[i])) {
                return new int[]{diffs.get(arr[i]), i};
            } else {
                diffs.put(target - arr[i], i);
            }
        }

        return new int[] {};
    }
}
