package com.preparation.ds.list.impl;

public class CustomLinkedList<T> {

    private Node head = null;

    public Node getHead() {
        return head;
    }

    public void add(T data) {
        if (head == null) {
            head = new Node<T>(data, null);
            return;
        }

        Node<T> newNode = new Node<>(data, null);
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }


    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(String.format("%s -> ", temp.data));
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
