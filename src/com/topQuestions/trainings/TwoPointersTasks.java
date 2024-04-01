package com.topQuestions.trainings;

import java.util.Arrays;

public class TwoPointersTasks {

    public static void main(String[] args) {
//        String s = "abc def";
//        reverseWordsInString(s);

//        int[] arr1 = {1, 3, 5, 7, 0, 0, 0, 0};
//        int[] arr2 = {2, 4, 6, 8};
//        mergeArrays(arr1, arr2, 4, 4);

//        String s1 = "abc";
//        String s2 = "def";
//        mergeStringAlternately(s1, s2);

//        String s3 = "abcdbba";
//        System.out.println(validPalindromeWithRemovingCharacter(s3));

//        int[] arr3 = {4, 0, 5, 0, 0, 2};
//        moveZeroes(arr3);

//        int[] arr4 = {1, 1, 2, 3, 4, 4};
//        removeDuplicatesFromSortedArray(arr4);

//        int[] arr5 = {1,3,1,4,1,4,4};
//        removeElement(arr5, 1);
        
//        int[] arr6 = {2,3,8,7,6,3};
//        sortArrayByParity(arr6);

//        String s4 = "badvfer";
//        reverseVowelsOfString(s4);

//        String s5 = "";
//        String s6 = "";
//        isSubsequence(s5, s6);

//        int[] arr7 = {-4, -2, 0, 5, 11};
//        getSquaresOfASortedArray(arr7);

        String s7 = "abcdefgh";
        reverseStringII(s7, 2);


    }

    private static void reverseStringII(String s, int k) {
        char[] strArray = s.toCharArray();

        for (int i = 0; i < strArray.length; i += 2*k) {
            int left = i;
            int right = i + k - 1;

            while (left < right) {
                char temp = strArray[left];
                strArray[left++] = strArray[right];
                strArray[right--] = temp;
            }
        }

        System.out.println(String.valueOf(strArray));
    }


    private static void reverseVowelsOfString(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] charArr = s.toCharArray();

        while (left < right) {
            if (!isVowel(charArr[left])) {
                left++;
            }

            if (!isVowel(charArr[right])) {
                right--;
            }

            if (isVowel(charArr[left]) && isVowel(charArr[right])){
                char temp = charArr[left];
                charArr[left++] = charArr[right];
                charArr[right--] = temp;
            }
        }

        System.out.println(Arrays.toString(charArr));
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i'|| c == 'o' || c == 'u';
    }


    private static boolean validPalindromeWithRemovingCharacter(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean isReplaced = false;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return checkPalindrome(s, start, end - 1) || checkPalindrome(s, start + 1, end);

            }

            start++;
            end--;
        }

        return true;
    }

    private static boolean checkPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }


    private static String reverseWordsInString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int length = s.length();
        char[] chArray = s.toCharArray();

        int start = 0;

        for (int i = 0; i <= length; i++) {
            if (i == length || chArray[i] == ' ') {
                int end = i - 1;
                while (start < end) {
                    char temp = chArray[start];
                    chArray[start++] = chArray[end];
                    chArray[end--] = temp;
                }
                start = i + 1;
            }
        }

        System.out.println(new String(chArray));

        return new String(chArray);
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2, int m, int n) {
        //1,3,5,7
        //2,4,6,8
        int pointer1 = m - 1;
        int pointer2 = n - 1;

        for (int i = arr1.length - 1; i > 0; i--) {

            if (pointer2 < 0) {
                break;
            }

            if (pointer1 > 0 && arr1[pointer1] >= arr2[pointer2]) {
                arr1[i] = arr1[pointer1--];
            } else {
                arr1[i] = arr2[pointer2--];
            }
        }

        System.out.println(Arrays.toString(arr1));
        return arr1;
    }

    private static String mergeStringAlternately(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        StringBuilder result = new StringBuilder();

        int s1Pointer = 0;
        int s2Pointer = 0;

        while (s1Pointer < s1Length || s2Pointer < s2Length) {
            if (s1Pointer < s1Length) {
                result.append(s1.charAt(s1Pointer++));
            }

            if (s2Pointer < s2Length) {
                result.append(s2.charAt(s2Pointer++));
            }
        }

        System.out.println(result.toString());

        return result.toString();
    }


    private static void moveZeroes(int[] arr) {
        int lastNonZeroIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[lastNonZeroIndex++] = arr[i];
            }
        }

        for (int i = lastNonZeroIndex; i < arr.length; i++) {
            arr[i] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }

    //1 1 2 3 3 4
    //1 1
    private static int removeDuplicatesFromSortedArray(int[] arr) {
        int insertIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                arr[insertIndex++] = arr[i];
            }
        }

        System.out.println(insertIndex - 1);
        return insertIndex - 1;
    }

    private static void removeElement(int[] arr, int value) {
        int insertIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != value) {
                arr[insertIndex++] = arr[i];
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void sortArrayByParity(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] % 2 == 1 && arr[right] % 2 == 0) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }

            if (arr[left] % 2 == 0) {
                left++;
            }

            if (arr[right] % 2 == 1) {
                right--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static boolean isSubsequence(String s1, String s2) {
        Integer leftBound = s1.length(), rightBound = s2.length();
        Integer pLeft = 0, pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            // move both pointers or just the right pointer
            if (s1.charAt(pLeft) == s2.charAt(pRight)) {
                pLeft++;
            }
            pRight++;
        }
        return pLeft == leftBound;
    }

    private static int[] getSquaresOfASortedArray(int[] arr) {
        int[] result = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        int index = result.length - 1;

        while (left <= right) {
            int leftMemberSquare = arr[left] * arr[left];
            int rightMemberSquare = arr[right] * arr[right];
            if (leftMemberSquare >= rightMemberSquare) {
                result[index--] = leftMemberSquare;
                left++;
            } else {
                result[index--] = rightMemberSquare;
                right--;
            }
        }
        System.out.println(Arrays.toString(result));

        return result;
    }
}
