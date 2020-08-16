package com.preparation.ds.list.questions;

/**
 * Problem: how to deep clone when the node not even exist of random pointer.
 * <p>
 * Algo 1: with o(n) space, use HashMap to record the next and current like HashMap<originalListNode,copiedListNode>
 * <p>
 * Algo 2: with o(1) space:
 * 1. copy the complete list into new with only next;
 * 2. while copying change the next of original to point to current node of copied list. And arbitary pointer of copied to original node.
 * 3. Now to obtain the random node for each node of copied list, traverse copied and make the arbitray = node.arbitary.randomPointer.next;
 */
public class CloneLLwithRandomPointer {
    public RandomNode head = null;

    public static CloneLLwithRandomPointer deepCloneLL(RandomNode originalNode) {
        CloneLLwithRandomPointer copied = new CloneLLwithRandomPointer();
        RandomNode prev = originalNode;
        //1. traversing
        while (originalNode != null) {

            RandomNode copiedNode = copied.add(originalNode.data, originalNode);
            prev = originalNode;
            originalNode = originalNode.next;
            prev.next = copiedNode;
        }

        //step 3: changinf=g random pointer of newly creaetd list
        RandomNode head = copied.getHead();
        while (head != null) {
            head.randomNode = head.randomNode.randomNode.next;
            head = head.next;
        }

        return copied;
    }

    public RandomNode add(int data, RandomNode randomNode) {
        RandomNode node = new RandomNode(data, null, randomNode);
        if (head == null) {
            head = node;
            return head;
        }
        RandomNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        return node;
    }

    public void display() {
        RandomNode curr = head;
        while (curr != null) {
            System.out.println(curr.data + " " + curr.next + " " + curr.randomNode);

            curr = curr.next;
        }
    }

    public RandomNode getHead() {
        return head;
    }

    static class RandomNode {
        int data;
        RandomNode next;
        RandomNode randomNode;

        RandomNode(int data, RandomNode next, RandomNode randomNode) {
            this.data = data;
            this.next = next;
            this.randomNode = randomNode;
        }

        public String toString() {
            return "" + data;
        }


    }

    public static void main(String... s) {
        CloneLLwithRandomPointer ll = new CloneLLwithRandomPointer();
        RandomNode node1 = ll.add(1, null);
        RandomNode node2 = ll.add(2, null);
        RandomNode node3 = ll.add(3, node1);
        RandomNode node4 = ll.add(4, node2);
        RandomNode node5 = ll.add(5, node1);
        node1.randomNode = node4;
        node2.randomNode = node5;
        ll.display();
        CloneLLwithRandomPointer abc = CloneLLwithRandomPointer.deepCloneLL(node1);
        abc.display();

    }
}