package com.preparation.ds.list.questions.algorithm;

import com.preparation.ds.list.impl.CustomLinkedList;
import com.preparation.ds.list.impl.Node;

public class ReverseAList {

    public static Node reverse(Node head) {
        if (head == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node temp = curr;
            curr = curr.next;

            temp.next = prev;
            prev = temp;
        }

        return prev;
    }

    public static void main(String... s){
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);

        System.out.println(reverse(ll.getHead()));
    }
}
