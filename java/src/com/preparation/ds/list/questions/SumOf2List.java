package com.preparation.ds.list.questions;

import com.preparation.ds.list.impl.CustomLinkedList;
import com.preparation.ds.list.impl.Node;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * <p>
 * Add two non empty listrepresenting two non negative integers.  The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class SumOf2List {

    public static void main(String... s) {
        CustomLinkedList<Integer> linkedList1 = new CustomLinkedList<>();
        linkedList1.add(2);
        linkedList1.add(4);
        linkedList1.add(3);

        CustomLinkedList<Integer> linkedList2 = new CustomLinkedList<>();
        linkedList2.add(5);
        linkedList2.add(6);
        linkedList2.add(4);

        Node addedList = addTwoNumbers(linkedList1.getHead(), linkedList2.getHead());
        System.out.println(addedList.toString());
    }

    public static Node addTwoNumbers(Node<Integer> head1, Node<Integer> head2) {
        int remainder = 0;
        Node addedList = null;
        Node curr = addedList;
        while (head1 != null && head2 != null) {
            int sum = remainder + head1.data + head2.data;
            Node newNode = new Node(sum % 10, null);
            if (addedList == null) {
                addedList = newNode;
                curr = addedList;
            } else {
                curr.next = newNode;
                curr = newNode;
            }
            remainder = sum / 10;
            head1 = head1.next;
            head2 = head2.next;
        }

        if (head1 == null && head2 == null) {
            if (remainder != 0) {
                curr.next = new Node(remainder, null);
            }
        } else if (head1 == null) {
            addRemaining(head2, remainder, curr);
        } else if (head2 == null) {
            addRemaining(head1, remainder, curr);
        }

        return addedList;
    }


    private static void addRemaining(Node<Integer> head, int remainder, Node<Integer> curr) {
        while (head != null) {
            int data = head.data + remainder;
            head.data = data % 10;
            remainder = data / 10;
            curr.next = new Node(head.data, null);
            curr = curr.next;
            head = head.next;
        }
        if (remainder != 0) {
            curr.next = new Node(remainder, null);
        }
    }


}
