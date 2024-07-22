package com.topQuestions.easy;

import com.topQuestions.easy.trainings.LinkedListTrainings;

public class Trainings2 {
    public static void main(String[] args) {
        LinkedNode head1 = new LinkedNode(1);
        head1.next = new LinkedNode(3);
        head1.next.next = new LinkedNode(4);
        head1.next.next.next = new LinkedNode(6);
        head1.next.next.next.next = new LinkedNode(8);

        LinkedNode head2 = new LinkedNode(2);
        head2.next = new LinkedNode(5);
        head2.next.next = new LinkedNode(11);

        //reverse(head1);
        //System.out.println(isLoop(head1));
        String[] s1 = {"floor", "floo", "fll"};
        System.out.println(getPrefix(s1));
    }

    private static String getPrefix(String[] s) {
        String prefix = s[0];

        for (int i = 1; i < s.length; i++) {
            int minLength = Math.min(prefix.length(), s[i].length());

            for (int j = 0; j < minLength; j++) {
                if (prefix.charAt(j) != s[i].charAt(j)){
                    prefix = prefix.substring(0, j);
                    break;
                }
                prefix = prefix.substring(0, minLength);
            }
        }

        return prefix;
    }

    private static boolean isLoop(LinkedNode head) {
        LinkedNode slow = head;
        LinkedNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    private static void reverse(LinkedNode head) {
        LinkedNode prev = null;
        LinkedNode curr = head;

        while (curr != null) {
            LinkedNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        printLL(prev);
    }

    static class LinkedNode {
        public int val;

        public LinkedNode next;

        public LinkedNode(int val) {
            this.val = val;
        }
    }

    public static void printLL(LinkedNode curr) {
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
        }
    }
}
