package com.preparation.ds.list.questions.algorithm;

public class Merge2SortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        return merge(l1, l2);
    }

    private ListNode merge(ListNode f, ListNode s) {

        ListNode head = null;
        if (f.val <= s.val) {
            head = f;
            f = f.next;
        } else {
            head = s;
            s = s.next;
        }

        ListNode curr = head;
        while (f != null && s != null) {
            if (f.val <= s.val) {
                curr.next = f;
                f = f.next;
            } else {
                curr.next = s;
                s = s.next;
            }
            curr = curr.next;
        }

        if (f != null) curr.next = f;
        if (s != null) curr.next = s;
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;
    }
}
