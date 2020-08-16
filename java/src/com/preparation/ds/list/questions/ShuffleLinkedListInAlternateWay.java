package com.preparation.ds.list.questions;

import com.preparation.ds.list.impl.CustomLinkedList;
import com.preparation.ds.list.impl.Node;

/**
 * Given a doubly linked list of even size
 * <p>
 * Divide it into 2 parts from mid and then merge it likw first element from second half , first element of first half and so on.
 * Space complexity has to be o(1)
 * Ex:
 * <p>
 * 8 9 10 11 1 2 3 4 5 6
 * <p>
 * OUTPUT:
 * 2 8 3 9 4 10 5 11 6 1
 * <p>
 * (asked in Amazon)
 * <p>
 * <p>
 * Follow up question : List wil always be of even size. Memory complexity? List or array?
 * <p>
 * <p>
 * Algo:
 * 1. Split the list in 2 halfes
 * 2. Merge in alternate fashion of 2 linkedlist.
 * <p>
 * Node half = splitAtHalf(head);
 * interleave(head,half)
 * head=half;
 */
public class ShuffleLinkedListInAlternateWay {


    static Node splitAtHalf(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        Node seconHead = slowPointer.next;
        slowPointer.next = null;

        return seconHead;
    }

    static Node shuffle(Node first, Node second) {
        Node start = second;
        while (second != null && first != null) {
            Node secondNext = second.next;
            Node firstNext = first.next;

            second.next = first;
            first.next = secondNext;

            second = secondNext;
            first = firstNext;
        }
        return start;
    }


    public static void main(String... s) {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.display();
        Node secondHead = splitAtHalf(linkedList.getHead());
        System.out.println("second list start " + secondHead.toString());

        System.out.println(shuffle(linkedList.getHead(), secondHead));
    }


}
