package com.preparation.ds.graph.shortest.path;

import com.preparation.ds.graph.model.Edge;
import com.preparation.ds.graph.topological.TopologicalSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class DAGShortestPathBothPositiveNegativeEdges {

    public static void shortestPathDagAllEdges(Map<Integer, List<Edge>> graph, int start, int noOfNodes) {

        //obtain the topological sorting order and then traverse accordingly.
        int[] topSort = TopologicalSort.topologicalSort(graph, noOfNodes);

        //tracking distance of all nodes from the start, initially all 0
        Integer[] dist = new Integer[noOfNodes];
        dist[start] = 0;

        //Min weight algorithm
        for (int i = 0; i < noOfNodes; i++) {
            int nodeIndex = topSort[i];
            if (dist[nodeIndex] != null) {
                List<Edge> adjacentEdges = graph.get(nodeIndex);
                if (adjacentEdges != null) {
                    for (Edge edge : adjacentEdges) {
                        //check for each adjacent edge if existing value is < newDist
                        int newDist = dist[nodeIndex] + edge.weight;
                        if (dist[edge.to] == null) dist[edge.to] = newDist;
                        else dist[edge.to] = Math.min(dist[edge.to], newDist);
                    }
                }
            }
        }

        //print all distance from start
        Arrays.stream(dist).forEach(element -> System.out.print(element + " "));
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
        shortestPathDagAllEdges(graph, 0, 8);
    }

}
