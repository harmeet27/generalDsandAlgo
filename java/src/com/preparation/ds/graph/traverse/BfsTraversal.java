package com.preparation.ds.graph.traverse;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time Complexity O(V+E)
 *
 * @param <V>
 */
public class BfsTraversal<V> {

    public List<V> bfsTraversal(V root, HashMap<V, List<V>> adjList) {
        HashSet<V> visited = new HashSet<>();
        List<V> bfsTraverse = new LinkedList<>();

        Queue<V> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            V traversedElement = queue.poll();

            bfsTraverse.add(traversedElement);
            if (adjList.get(traversedElement) != null) {
                List<V> children = adjList.get(traversedElement);
                for (V child : children) {
                    if (!visited.contains(child)) {
                        queue.add(child);
                        visited.add(child);
                    }
                }
            }
        }
        return bfsTraverse;
    }


    public static void main(String... s) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(1, Arrays.asList(2, 4));
        adjList.put(2, Arrays.asList(3));
        adjList.put(4, Arrays.asList(5));
        adjList.put(5, Arrays.asList(1, 6));
        adjList.put(6, Arrays.asList(2));
        BfsTraversal<Integer> bfsTraversal = new BfsTraversal<>();
        List<Integer> bfs = bfsTraversal.bfsTraversal(1, adjList);
        System.out.println(bfs.toString());

    }

}
