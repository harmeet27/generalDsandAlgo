package com.preparation.ds.list.questions.algorithm.merge;

public class Merge2SortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        return merge(l1, l2);
    }

    private ListNode merge(ListNode f, ListNode s) {

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (f != null && s != null) {
            if (f.val <= s.val) {
                tail.next = f;
                f = f.next;
            } else {
                tail.next = s;
                s = s.next;
            }
            tail = tail.next;
        }

        if (f != null) tail.next = f;
        if (s != null) tail.next = s;

        dummyHead = dummyHead.next;
        return dummyHead;
    }


    public class ListNode {
        int val;
        ListNode next;
    }
}
