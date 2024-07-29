package com.topQuestions.middle.dataStructures;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;

    private Map<Integer, ListNode> map;

    ListNode head;

    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    //return the value of the key if the key exists, otherwise returns -1 (O(1))
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    private void add(ListNode node) {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        tail.prev = node;
        node.next = tail;
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    //update the value of the key if the key exists. Otherwise add the key-value pair
    //to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key (O(1))
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode oldNode = map.get(key);
            remove(oldNode);
        }

        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);
        add(newNode);

        if (map.size() > capacity) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            map.remove(nodeToDelete.key);
        }
    }
}

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
