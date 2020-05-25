package com.preparation.ds.list.questions;

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

    public static ReverseAList.SinglyLinkedListNode revereseInSizeK(ReverseAList.SinglyLinkedListNode head, int k) {
        int size = findSize(head);
        int total = size % k;
        Queue<ReverseAList.SinglyLinkedListNode> queue = new LinkedList<>();
        int traverseNodes = size - total;


        ReverseAList.SinglyLinkedListNode temp = null;
        ReverseAList.SinglyLinkedListNode prev = null;
        ReverseAList.SinglyLinkedListNode curr = head;
        ReverseAList.SinglyLinkedListNode first = null;
        boolean init = true;

        while (curr != null && traverseNodes > 0) {
            int count = k;
            ReverseAList.SinglyLinkedListNode start = curr;
            while (count > 0) {
                temp = prev;
                prev = curr;
                curr = curr.next;
                prev.next = temp;
                count--;
                traverseNodes--;
            }
            if (init == true) {
                init = false;
                first = prev;
            }
            queue.add(start);
            prev = null;
        }

        if (curr != null) {

            queue.add(curr);
        }
        ReverseAList.SinglyLinkedListNode sample = queue.poll();
        while (!queue.isEmpty()) {

            ReverseAList.SinglyLinkedListNode second = queue.poll();

            sample.next = second;
            sample = second;
        }
        return first;
    }

    private static int findSize(ReverseAList.SinglyLinkedListNode head) {
        int count = 0;
        ReverseAList.SinglyLinkedListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }


    public static ReverseAList.SinglyLinkedListNode revereseInSizeKRecursive(ReverseAList.SinglyLinkedListNode head, int k) {
        return null;
    }


}
