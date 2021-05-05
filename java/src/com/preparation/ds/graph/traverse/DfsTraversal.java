package com.preparation.ds.graph.traverse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DfsTraversal<V> {

    //traverse back will not happen as in case of recursion
    public List<V> dfsTraversalUsingStack(V root, HashMap<V, List<V>> adjList) {
        List<V> dfs = new LinkedList<>();
        Set<V> visited = new HashSet<>();
        Stack<V> stack = new Stack<>();

        stack.add(root);
        visited.add(root);

        while (!stack.isEmpty()) {
            V traversed = stack.pop();
            visited.add(traversed);
            dfs.add(traversed);

            if (adjList.get(traversed) != null) {
                for (V child : adjList.get(traversed)) {
                    if (!visited.contains(child)) {
                        stack.push(child);
                        visited.add(child);
                    }
                }
            }

        }

        return dfs;

    }

    public List<V> dfsRecursion(V root, HashMap<V, List<V>> adjList) {
        Set<V> visited = new HashSet<>();
        visited.add(root);
        return dfsTraversalUsingRecursion(root, adjList, visited);
    }

    private List<V> dfsTraversalUsingRecursion(V root, HashMap<V, List<V>> adjList, Set<V> visited) {
        List<V> dfs = new LinkedList<>();
        dfs.add(root);
        if (adjList.get(root) != null) {
            for (V child : adjList.get(root)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    dfs.addAll(dfsTraversalUsingRecursion(child, adjList, visited));
                }
            }
        }
        return dfs;
    }

    public static void main(String... s) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(1, Arrays.asList(2, 4));
        adjList.put(2, Arrays.asList(3));
        adjList.put(4, Arrays.asList(5));
        adjList.put(5, Arrays.asList(1, 6));
        adjList.put(6, Arrays.asList(2));
        DfsTraversal<Integer> dfsTraversal = new DfsTraversal();
        List<Integer> dfs = dfsTraversal.dfsRecursion(1, adjList);
        System.out.println(dfs.toString());
        System.out.println("----------------------STACK--------------------------------");
        List<Integer> dfsStack = dfsTraversal.dfsTraversalUsingStack(1, adjList);
        System.out.println(dfsStack.toString());

    }
}
