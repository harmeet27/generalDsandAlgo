package com.preparation.leetcode.thirtyday.challenge.dayfour;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * LRUCache cache = new LRUCache(capacity)
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {

    HashMap<Integer, Node> map = new HashMap();
    int size = 0;
    int capacity = 0;
    private DoublyLinkedList dll;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dll = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        dll.remove(node); //size++ and size-- will be even out here
        dll.add(node);
        return node.value;

    }

    public void put(int key, int value) {
        if (this.get(key) != -1) {
            this.map.get(key).value = value;
            return;
        }

        if (size == capacity) {
            this.evict();
        }
        Node node = new Node(key, value, null, null);
        dll.add(node);
        size++;
        map.put(key, node);
    }

    public void evict() {
        size--;
        map.remove(dll.head.key);
        dll.remove(dll.head);
    }

    class DoublyLinkedList {
        Node head;
        Node last;

        void add(Node node) {
            if (head == null) {
                head = node;
                last = node;
            } else {
                last.next = node;
                node.prev = last;
                node.next = null;
                last = node;
            }
        }

        void remove(Node node) {

            if (node == head) {
                Node temp = head;
                if (head != last) {
                    head = head.next;
                    temp.next = null;
                    head.prev = null;
                } else {
                    head = null;
                }
            } else if (node == last) {
                node.prev.next = null;
                last = node.prev;
                node.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
    }

    class Node {
        int value;
        Node prev;
        Node next;
        int key;

        Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }


    public static void main(String[] s) {
        LRUCache cache = new LRUCache(2 /* capacity */);

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
