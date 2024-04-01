package com.topQuestions.trainings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTasks {

    static class LinkedNode {
        public int val;

        public LinkedNode next;

        public LinkedNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        LinkedNode head1 = new LinkedNode(0);
        head1.next = new LinkedNode(2);
        head1.next.next = new LinkedNode(5);
        head1.next.next.next = new LinkedNode(8);

        LinkedNode head2 = new LinkedNode(1);
        head2.next = new LinkedNode(2);
        head2.next.next = new LinkedNode(7);
        //mergeTwoSortedLists(head1, head2);
        //getMiddleOfLinkedList(head1);
        reverseLinkedList(head1);
    }

    private static void reverseLinkedList(LinkedNode head) {
        LinkedNode curr = head;
        LinkedNode prev = null;
        while (curr != null) {
            LinkedNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        printLL(prev);
    }


    private static void mergeTwoSortedLists(LinkedNode node1, LinkedNode node2) {
        LinkedNode prev = new LinkedNode(0);
        LinkedNode curr = prev;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }

            curr = curr.next;
        }

        if (node1 == null) {
            curr.next = node2;
        } else {
            curr.next = node1;
        }

        printLL(prev.next);
    }

    private static int getMiddleOfLinkedList(LinkedNode head) {
        if (head == null || head.next == null) {
            return head.val;
        }

        LinkedNode slow = head;
        LinkedNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        return slow.val;
    }

    public static void printLL(LinkedNode curr) {
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
        }
    }
}
