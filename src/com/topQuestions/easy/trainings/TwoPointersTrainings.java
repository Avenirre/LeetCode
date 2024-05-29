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

        String s3 = "ab#c";
        String s4 = "ac";
        System.out.println(backspaceStringCompare(s3, s4));

        String s2 = "abbedsoo";
        System.out.println(reverseVowelsOfAString(s2));
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
