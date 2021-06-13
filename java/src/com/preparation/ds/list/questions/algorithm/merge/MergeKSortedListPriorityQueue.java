package com.preparation.ds.list.questions.algorithm.merge;

import java.util.PriorityQueue;

/**
 * Idea is to store the node in queue and keep polling.
 * How to keep track of which node we are in each linkedlist present in queue.
 */
public class MergeKSortedListPriorityQueue {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (f, s) -> Integer.compare(f.val, s.val));

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            //This is IMP: this is where we are adding further elements of a same list to queue.
            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }


    public class ListNode {
        int val;
        ListNode next;
    }

}