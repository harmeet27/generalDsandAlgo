package com.preparation.ds.list.questions;

import com.preparation.ds.list.impl.CustomLinkedList;
import com.preparation.ds.list.impl.Node;
import com.preparation.ds.list.questions.algorithm.ReverseAList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Idea is to keep track of start and end after evry reverse of size 3.
 * <p>
 * <p>
 * 2 Approaches:
 * <p>
 * 1. Recusrion
 * 2. Using stack to keep track of last start
 */
public class ReverseInSizeK {

    public static void main(String... s) {
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        int k = 4;
        System.out.println(reverseInSizeK(ll.getHead(), k));
    }

    private static Node reverseInSizeK(Node<Integer> head, int k) {
        Node curr =head;
        int x=k;

//        Node prev = reverseInK(head,k,prev);
        return null;
    }

    private static Node<Integer> reverseInK(Node<Integer> head, int k, Node previous) {
        int x = 0;
        Node prev = previous;
        Node curr = head;
        while (curr != null && x < k) {
            Node temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }

        return head;
    }

}
