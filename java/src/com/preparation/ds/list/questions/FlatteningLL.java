package com.preparation.ds.list.questions;

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

public class FlatteningLL {

    public Node flatten(Node root) {
        flattenNode(root);
        return root;
    }

    public Node flattenNode(Node root) {
        if (root == null)
            return root;

        if (root.next == null && root.child == null)
            return root;

        if (root.child == null) {
            return flattenNode(root.next);
        } else {
            Node tail = flattenNode(root.child);
            if (root.next != null) {
                Node temp = root.next;

                root.next = root.child;
                root.child.prev = root;

                tail.next = temp;
                temp.prev = tail;

                //null child
                root.child = null;
                return flattenNode(temp);
            } else {
                root.next = root.child;
                root.child.prev = root;
                root.child = null;
                return tail;
            }
        }
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }


    public static void main(String... s) {
        FlatteningLL ll = new FlatteningLL();
        Node root1 = new Node(1, null, null, null);
        Node root2 = new Node(2, root1, null, null);
        Node root3 = new Node(3, root2, null, null);
        Node root4 = new Node(4, root3, null, null);
        Node root5 = new Node(5, root4, null, null);
        Node root6 = new Node(6, root5, null, null);
        Node root7 = new Node(7, null, null, null);
        Node root8 = new Node(8, root7, null, null);
        Node root9 = new Node(9, root8, null, null);
        Node root10 = new Node(10, root9, null, null);
        Node root11 = new Node(11, null, null, null);
        Node root12 = new Node(12, root11, null, null);

        root1.next = root2;
        root2.next = root3;
        root3.next = root4;

        root3.child = root7;
        root7.next = root8;
        root8.next = root9;

        root8.child = root11;
        root11.next = root12;
        root9.next = root10;

        root4.next = root5;
        root5.next = root6;
        root2.next = root3;

        Node head = ll.flatten(root1);

        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }


    }
}
