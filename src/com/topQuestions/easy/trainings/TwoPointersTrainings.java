package com.topQuestions.easy.trainings;

import java.util.Arrays;

public class TwoPointersTrainings {

    public static void main(String[] args) {
//        int[] arr1 = {1,2,3,3,4,5,5,6};
//        System.out.println(removeDuplicatesFromSortedArray(arr1));

//        String s1 = "abc def";
//        System.out.println(reverseWordsInStringIII(s1));

//        int[] arr2 = {1, 2, 4, 2, 4, 8};
//        System.out.println(Arrays.toString(removeElement(arr2, 2)));

//        String s2 = "ab#c";
//        String s3 = "ac";
//        System.out.println(backspaceStringCompare(s2, s3));
//
//        String s4 = "abbedsoo";
//        System.out.println(reverseVowelsOfAString(s4));

//        String s5 = "ace";
//        String s6 = "abcde";
//        System.out.println(isSubsequence(s5, s6));

//        int[] arr2 = {-5, -2, 0, 2, 4, 7};
//        System.out.println(Arrays.toString(squaresOfSortedArray(arr2)));

        String s7 = "aabbaabbaabb";
        System.out.println(reverseStringIII(s7, 2));
    }

    private static String reverseStringIII(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(i + 2 * k - 1, chars.length - 1);
            while (start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }

        return new String(chars);

    }

    private static int[] squaresOfSortedArray(int[] arr) {
        int[] result = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;
        int currentIndex = arr.length - 1;

        while (start <= end) {
            if (arr[start] * arr[start] >= arr[end] * arr[end]) {
                result[currentIndex--] = arr[start] * arr[start];
                start++;
            } else {
                result[currentIndex--] = arr[end] * arr[end];
                end--;
            }
        }

        return result;
    }

    private static boolean isSubsequence(String s1, String s2) {
        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < s1.length() && pointer2 < s2.length()) {
            if (s1.charAt(pointer1) == s2.charAt(pointer2)) {
                pointer1++;
            }

            pointer2++;
        }

        return pointer1 == s1.length();
    }

    private static String reverseVowelsOfAString(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (!isWovel(chars[start])) {
                start++;
            } else if (!isWovel(chars[end])) {
                end--;
            } else {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }

        return new String(chars);
    }

    private static boolean backspaceStringCompare(String s1, String s2) {
        int pointer1 = s1.length() - 1;
        int pointer2 = s2.length() - 1;
        int skip1 = 0;
        int skip2 = 0;

        while (pointer1 >= 0 || pointer2 >= 0) {
            while (pointer1 >= 0) {
                if (s1.charAt(pointer1) == '#') {
                    skip1++;
                    pointer1--;
                } else if (skip1 > 0) {
                    skip1--;
                    pointer1--;
                } else break;
            }

            while (pointer2 >= 0) {
                if (s2.charAt(pointer1) == '#') {
                    skip2++;
                    pointer2--;
                } else if (skip1 > 0) {
                    skip2--;
                    pointer2--;
                } else break;
            }

            if (pointer1 >= 0 && pointer2 >= 0 && s1.charAt(pointer1) != s2.charAt(pointer2)) {
                return false;
            }

            if (pointer1 < 0 || pointer2 < 0) {
                return false;
            }

            pointer1--;
            pointer2--;
        }

        return true;


    }

    private static boolean isWovel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static int[] removeElement(int[] arr, int target) {
        int indexToInsert = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target) {
                arr[indexToInsert++] = arr[i];
            }
        }

        return arr;
    }

    private static String reverseWordsInStringIII(String s) {
        char[] chars = s.toCharArray();
        int beginIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                endIndex = i - 1;
                swap(chars, beginIndex, endIndex);
                beginIndex = i + 1;
            } else if (i == chars.length - 1) {
                endIndex = i;
                swap(chars, beginIndex, endIndex);
            }
        }

        return String.copyValueOf(chars);
    }

    private static void swap(char[] chars, int beginIndex, int endIndex) {
        char temp = chars[beginIndex];
        chars[beginIndex] = chars[endIndex];
        chars[endIndex] = temp;
    }

    private static int removeDuplicatesFromSortedArray(int[] arr) {
        int indexToInsert = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[indexToInsert++] = arr[i];
            }
        }

        return indexToInsert;

    }
}
