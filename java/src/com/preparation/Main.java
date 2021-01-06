package com.preparation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class Main {

    HashMap<Integer, Node> cache = new HashMap();
    Node head;
    Node last;
    int capacity = 0;
    int size = 0;

    public Main(int capacity) {
        cache = new HashMap();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node value = cache.getOrDefault(key, null);
        if (value != null) {
            remove(value);
            add(value);

            return value.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            add(cache.get(key));
        } else {
            Node newNode = new Node(value, null, null);
            newNode.key = key;
            if (size == capacity) {
                Node temp = cache.get(head.key);
                cache.remove(temp.key);
                remove(temp);
                add(newNode);
                size = size - 1;
            } else {
                add(newNode);
            }
            cache.put(key, newNode);
            size += 1;
        }

    }

    private void add(Node newNode) {
        if (last == null) {
            head = newNode;
            last = head;
            return;
        }

        last.next = newNode;
        newNode.prev = last;
        last = newNode;
    }


    private void remove(Node removeNode) {
        if (head == null) {
            return;
        }

        //single element
        if (head == last && head == removeNode) {
            removeNode.next = null;
            removeNode.prev = null;
            head = null;
            last = null;
            return;
        }

        //remove from front
        if (head == removeNode) {
            head = head.next;
            head.prev = null;
            removeNode.next = null;
            return;
        }

        //remove from last
        if (last == removeNode) {
            last = last.prev;
            removeNode.prev = null;
            last.next = null;
            return;
        }

        Node prevNode = removeNode.prev;
        prevNode.next = removeNode.next;
        removeNode.next.prev = prevNode;

        removeNode.next = null;
        removeNode.prev = null;
    }


    public class Node {
        public int val;
        public Node next;
        public Node prev;
        public int key;

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String... s) {
        BigDecimal decimal = new BigDecimal(597582.40);
        BigDecimal num = decimal.divide(BigDecimal.valueOf(1000000));
        BigDecimal roundedDec = num.setScale(0, RoundingMode.HALF_UP);
//        BigDecimal roundedDecimal = roundedDec.setScale(2);
        int n = roundedDec.intValue();
        System.out.println(n);
    }
}
