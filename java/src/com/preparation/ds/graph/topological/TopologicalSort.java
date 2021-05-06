package com.preparation.ds.graph.topological;

import com.preparation.ds.graph.model.Edge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Topological sort is only applicable to DAG
 */
public class TopologicalSort {

    public static int[] topologicalSort(Map<Integer, List<Edge>> graph, int totalNodes) {

        int[] nodesInDegree = new int[totalNodes];
        graph.forEach((k, v) -> v.forEach(child -> nodesInDegree[child.to] += 1));
        int[] topSort = new int[totalNodes];
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(graph.keySet().stream().filter(element -> nodesInDegree[element] == 0).collect(Collectors.toList()));

        int nodesCount = 0;

        while (!queue.isEmpty()) {
            Integer traversed = queue.poll();
            topSort[nodesCount++] = traversed;
            if (graph.get(traversed) != null) {
                for (Edge edge : graph.get(traversed)) {
                    nodesInDegree[edge.to] -= 1;
                    if (nodesInDegree[edge.to] == 0) {
                        queue.add(edge.to);
                    }
                }
            }
        }
        if (nodesCount < totalNodes) {
            System.out.println("Not a valid topological sort dependency");
        }

        return topSort;
    }

    public static void main(String... s) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(new Edge(1, 3), new Edge(2, 6)));
        graph.put(1, Arrays.asList(new Edge(3, 4), new Edge(4, 11)));
        graph.put(2, Arrays.asList(new Edge(3, 8), new Edge(6, 11)));
        graph.put(3, Arrays.asList(new Edge(4, -4), new Edge(5, 5), new Edge(6, 2)));
        graph.put(4, Arrays.asList(new Edge(7, 9)));
        graph.put(5, Arrays.asList(new Edge(7, 1)));
        graph.put(6, Arrays.asList(new Edge(7, 2)));
        graph.put(7, new LinkedList<>());
        topologicalSort(graph, graph.size());
    }
}
