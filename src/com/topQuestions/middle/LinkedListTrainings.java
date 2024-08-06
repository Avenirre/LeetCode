package com.topQuestions.middle;

public class LinkedListTrainings {
    public static void main(String[] args) {
        ListNode node1a = new ListNode(2);
        ListNode node2a = new ListNode(4);
        ListNode node3a = new ListNode(3);
        ListNode node1b = new ListNode(5);
        ListNode node2b = new ListNode(6);
        ListNode node3b = new ListNode(4);
        node1a.next = node2a;
        node2a.next = node3a;
        node1b.next = node2b;
        node2b.next = node3b;
        System.out.println(addTwoNumbers(node1a, node1b));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int adder = 0;

        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode prev = new ListNode(-1);
        ListNode current = prev;

        while (node1 != null || node2 != null || adder != 0) {
            int node1Val = node1 == null ? 0 : node1.val;
            int node2Val = node2 == null ? 0 : node2.val;

            int currentSum = node1Val + node2Val + adder;
            if (currentSum > 9) {
                current.next = new ListNode(currentSum - 10);
            } else {
                current.next = new ListNode(currentSum);
            }
            adder = currentSum / 10;

            if (node1 != null) {
                node1 = node1.next;
            }

            if (node2 != null) {
                node2 = node2.next;
            }

            current = current.next;
        }

        return prev.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
