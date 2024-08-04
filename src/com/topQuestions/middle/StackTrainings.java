package com.topQuestions.middle;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StackTrainings {

    public static void main(String[] args) {
        String s1 = "lee(t(c)o)de)";
        System.out.println(minimumRemoveToMakeValidParentheses(s1));
    }

    private static String minimumRemoveToMakeValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
