package com.preparation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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
        isValid("110","011");

    }

    private static boolean isValid(String car, String otherCar){
        int xor=0;
        for(int i=0;i<car.length();i++){
            xor=xor^(car.charAt(i));
        }

        for(int i=0;i<otherCar.length();i++){
            xor=xor^(otherCar.charAt(i));
        }

        if(xor==0 || xor==1)
            return true;

        return false;


    }
}
