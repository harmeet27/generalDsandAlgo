package com.preparation.ds.list.questions;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Idea is to keep track of start and end after evry reverse of size 3.
 * <p>
 * <p>
 * 2 Approaches:
 * <p>
 * 1. with extra space use Map based approach
 * store the start and end of each reverse operation in LinkedHashMap.
 * At last traverse and link back of each
 * 1. Using HashMap --> O(n) time and space(o(2n)) in worst case.
 * Algo:
 * Whenever we encounter i as k, make the prev pointing to the end of this k list as null,
 * while current is moved forward to next list starting.
 * Reverse(start) of this k list and store both the start, end of the list in map in order.
 * <p>
 * Keep doing this.
 * <p>
 * if i!=k and loop terminates, meaning there are no further k elements in list, in this
 * case store the start and end as start only.
 * <p>
 * <p>
 * 1. Recursion
 * 2. Using stack to keep track of last start
 */
public class ReverseInSizeK {

    static LinkedHashMap<Integer, Map.Entry<ListNode, ListNode>> map = new LinkedHashMap();

    public static ListNode reverseKGroupUsingMap(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        int j = 0;
        while (curr != null) {
            ListNode start = curr;
            int i = 0;
            ListNode prev = curr;
            while (i < k && curr != null) {
                prev = curr;
                curr = curr.next;
                i++;
            }
            prev.next = null;
            //for list with no further nodes of size k , keep the end as start only.
            ListNode end = i == k ? reverse(start) : start;
            AbstractMap.SimpleEntry<ListNode, ListNode> nodes = new AbstractMap.SimpleEntry(end, start);
            map.put(++j, nodes);
        }

        Map.Entry<ListNode, ListNode> previous = null;
        if (map != null && map.containsKey(1)) {
            previous = map.get(1);
        }

        for (int l = 2; l <= map.size(); l++) {
            ListNode val = previous.getValue();
            val.next = map.get(l).getKey();
            previous = map.get(l);
        }

        return map.get(1).getKey();
    }


    private static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = prev;
            prev = curr;
            curr = curr.next;
            prev.next = temp;
        }

        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        //1->2->3->4->5->6->7 k=3
        //start:1,4,7
        //end: 3,6
        if (head == null) return head;

        ListNode startNode = head;
        ListNode curr = head;
        int count = 1;

        while (curr.next != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count < k) {
            //meaning total elements are less than k now --> return head as it is dont reverese this window.
            return head;
        }

        ListNode nextIteratorNode = curr.next; //before breaking the current window, store the further.
        curr.next = null;
        ListNode endNode = curr;
        reverse(startNode);
        startNode.next = reverseKGroup(nextIteratorNode, k);
        return endNode;
    }


    public static void main(String... s) {

        int k = 3;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

//        ListNode head = reverseKGroupUsingMap(node1, k);
        ListNode head = reverseKGroup(node1, k);
        while (head != null) {
            System.out.print(head.val + "--> ");
            head = head.next;
        }

    }

}
