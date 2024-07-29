package com.topQuestions.middle.dataStructures;

public class Main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        lruCache.get(1);
        lruCache.put(2, 1);
        lruCache.get(2);
    }
}
