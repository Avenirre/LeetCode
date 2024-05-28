package com.topQuestions.easy.trainings;

import java.util.Stack;

public class StackTrainings {

    public static void main(String[] args) {
        String s1 = "({[]})";
        System.out.println(validParenthesis(s1));
    }

    private static boolean validParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '{') {
                stack.push('}');
            } else if (currentChar == '(') {
                stack.push(')');
            } else if (currentChar == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != currentChar) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
