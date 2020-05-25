package com.preparation.ds.list.questions;

public class ReverseAList {

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode curr = head;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode temp = null;
        while (curr != null) {
            temp = prev;
            prev = curr;
            curr = curr.next;
            prev.next = temp;

        }

        return prev;

    }

    public class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }
}
