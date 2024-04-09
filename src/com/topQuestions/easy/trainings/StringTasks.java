package com.topQuestions.easy.trainings;

import java.util.HashMap;
import java.util.Map;

public class StringTasks {

    public static void main(String[] args) {
        String s1 = "abcabd";
        System.out.println(firstUniqueCharacterInAString(s1));
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
}
