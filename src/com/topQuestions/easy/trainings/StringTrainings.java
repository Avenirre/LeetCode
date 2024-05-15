package com.topQuestions.easy.trainings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringTrainings {

    public static void main(String[] args) {
//        String s1 = "abcba";
//        System.out.println(firstUniqueCharacterInAString(s1));

//        String s3 = "01010101";
//        System.out.println(maximumScoreAfterSplittingAString(s3));

        String s4 = "abbnsa";
        System.out.println(largestSubstringBetweenTwoEqualsCharacters(s4));
    }

    private static int largestSubstringBetweenTwoEqualsCharacters(String s) {
        int result = -1;
        Map<Character, Integer> stats = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (stats.containsKey(currentChar)) {
                result = Math.max(result, i - stats.get(currentChar) - 1);
            } else {
                stats.put(currentChar, i);
            }
        }

        return result;
    }

    private static int maximumScoreAfterSplittingAString(String s) {
        int result = (int) s.chars().filter(ch -> ch == '1').count();
        int currentResult = result;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                result = Math.max(++currentResult, result);
            } else {
                currentResult--;
            }
        }
        return result;
    }

    private static char firstUniqueCharacterInAString(String s) {
        int[] stats = new int[26];

        for (int i = 0; i < s.length(); i++) {
            stats[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (stats[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return ' ';
    }
}
