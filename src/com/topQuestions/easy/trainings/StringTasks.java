package com.topQuestions.easy.trainings;

import java.util.*;

public class StringTasks {

    public static void main(String[] args) {
//        String s1 = "abcabd";
//        System.out.println(firstUniqueCharacterInAString(s1));
//        String s2 = "badc";
//        String t2 = "baba";
//        System.out.println(isomorphicStrings(s2, t2));
//        String s3 = "011101";
//        System.out.println(maxScore(s3));
//        int[] arr1 = {1,1,2,3,3};
//        System.out.println(singleNumber(arr1));
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(findWordsThatCanBeFormedByCharacters(words, chars));
    }

    private static int findWordsThatCanBeFormedByCharacters(String[] words, String chars) {
        int result = 0;
        int[] stats = new int[26];

        for (int i = 0; i < chars.length(); i++) {
            stats[chars.charAt(i) - 'a']++;
        }

        for (String word: words) {
            int[] wordStats = new int[26];
            for (char ch : word.toCharArray()) {
                wordStats[ch - 'a']++;
            }

            boolean isGood = true;
            for (int i = 0; i < 26; i++) {
                if (stats[i] < wordStats[i]) {
                    isGood = false;
                    break;
                }
            }

            if (isGood) {
                result += word.length();
            }
        }

        return result;
    }

    private static int firstUniqueCharacterInAString(String s) {
        int[] stats = new int[26];

        for (int i = 0; i < s.length(); i++) {
            stats [s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (stats[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    private static boolean isomorphicStrings(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] mappingDictStoT = new int[26];
        Arrays.fill(mappingDictStoT, -1);

        int[] mappingDictTtoS = new int[26];
        Arrays.fill(mappingDictTtoS, -1);

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case 1: No mapping exists in either of the dictionaries
            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }

            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }

        return true;
    }

    private static int maxScore(String s) {
        int leftSum = s.charAt(0) == '0' ? 1 : 0;

        int rightSum = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                rightSum++;
            }
        }

        int totalSum = leftSum + rightSum;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                leftSum++;
            } else {
                rightSum--;
            }
            int currentTotalSum = leftSum + rightSum;

            if (currentTotalSum > totalSum) {
                totalSum = currentTotalSum;
            }
        }

        return totalSum;
    }

    private static int singleNumber(int[] arr) {
        int arrSum = 0;

        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
        }

        Set<Integer> set = new HashSet<>();
        int setSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (set.add(arr[i])) {
                setSum += arr[i];
            }
        }

        return 2 * setSum - arrSum;
    }
}
