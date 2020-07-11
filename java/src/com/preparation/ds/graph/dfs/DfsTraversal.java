package com.preparation.ds.graph.dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DfsTraversal {

    //recursion with loop
    //ex: max path sum here

    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    static {
        LinkedList l1 = new LinkedList();
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        adjList.put(1, l1);
        LinkedList l2 = new LinkedList();
        l2.add(6);
        l2.add(7);
        l2.add(8);
        l2.add(9);
        adjList.put(2, l2);
        LinkedList l3 = new LinkedList();
        l3.add(10);
        l3.add(11);
        adjList.put(4, l3);
        LinkedList l4 = new LinkedList();
        l4.add(12);
        l4.add(13);
        adjList.put(11, l4);
    }

    public static int performDfsTraversal(int node) {
        System.out.println("NOde executing : " + node);
        int maxNode = -1;
        int currNode = -1;
        if (adjList.get(node) == null) {
            return node;
        }
        for (Integer parent : adjList.get(node)) {
            currNode = performDfsTraversal(parent);
            if (currNode > maxNode) {
                maxNode = currNode;
            }
        }
        return maxNode + node;
    }

    public static void main(String[] s) {
        System.out.println(performDfsTraversal(1));
    }
}
