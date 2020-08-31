package com.preparation.leetcode.thirtyday.challenge.dayfour;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCacheDequeue {

    HashMap<Integer, Node> cache;
    int capacity = 0;
    Deque<Node> deque;

    public LRUCacheDequeue(int capacity) {
        this.capacity = capacity;
        deque = new LinkedList<>();
        cache = new HashMap();

    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        deque.remove(node);
        deque.addLast(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (this.get(key) != -1) {
            cache.get(key).value = value;
            return;
        }

        if (deque.size() == capacity) {
            this.evict();
        }
        deque.addLast(newNode);
        cache.put(key, newNode);
    }

    public void evict() {
        Node node = deque.removeFirst();
        cache.remove(node.key);
    }

    class Node {
        int value;
        Node prev;
        Node next;
        int key;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] s) {
        LRUCacheDequeue cache = new LRUCacheDequeue(2 /* capacity */);

        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
