package com.topQuestions.middle;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowTrainings {
    public static void main(String[] args) {
        String s1 = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s1));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int result = 0;

        Map<Character, Integer> stats = new HashMap<>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!stats.containsKey(s.charAt(i)) || stats.get(s.charAt(i)) < start) {
                result = Math.max(result, i - start + 1);
            } else {
                start = stats.get(s.charAt(i)) + 1;
            }

            stats.put(s.charAt(i), i);
        }

        return result;
    }
}
