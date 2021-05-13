package com.preparation.ds.graph.shortest.path;

import com.preparation.ds.graph.model.Edge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * failing few cases with TLE, most voted solution is failing for those 2 testcases too on leetcode.
 */
public class CheapestFlightWithKStopsBFS {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<Edge>> graph = buildGraph(flights);
        PriorityQueue<Node> queue = new PriorityQueue<Node>((f, s) -> Integer.compare(f.cost, s.cost));

        queue.add(new Node(src, 0, K + 1));
        int minPathSum = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.source == dst) {
                return minPathSum;
            }

            if (current.k >= 0) {
                if (graph.containsKey(current.source) && graph.get(current.source) != null) {
                    for (Edge child : graph.get(current.source)) {
                        queue.add(new Node(child.to, current.cost + child.weight, current.k - 1));
                    }
                }
            }
        }

        return -1;
    }

    private static Map<Integer, List<Edge>> buildGraph(int[][] flights) {
        Map<Integer, List<Edge>> graph = new HashMap();
        for (int i = 0; i < flights.length; i++) {
            List<Edge> edges = graph.getOrDefault(flights[i][0], new LinkedList());
            edges.add(new Edge(flights[i][1], flights[i][2]));
            graph.put(flights[i][0], edges);
        }

        return graph;
    }

    static class Node {
        public int source;
        public int cost;
        public int k;

        public Node(int source, int cost, int k) {
            this.k = k;
            this.cost = cost;
            this.source = source;
        }


        public static void main(String... s) {
            int n = 5;
            int[][] flights = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
            int src = 0;
            int dst = 2;
            int k = 2;

            CheapestFlightWithKStopsBFS cheapestFlightWithKStopsBFS = new CheapestFlightWithKStopsBFS();
            cheapestFlightWithKStopsBFS.findCheapestPrice(n, flights, src, dst, k);
        }
    }
}
