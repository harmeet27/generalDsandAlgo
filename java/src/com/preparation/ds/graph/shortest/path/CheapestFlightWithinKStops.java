package com.preparation.ds.graph.shortest.path;

import com.preparation.ds.graph.model.Edge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Algo 1: Simple memoization with DP E*V
 * Algo2: DFS (priorityQueue) : V+ElogV
 */
public class CheapestFlightWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<Edge>> graph = buildGraph(flights);

        int[][] memo = new int[n + 1][K + 2];
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE));

        int total = findPrice(graph, src, dst, K + 1, memo);
        return total == Integer.MAX_VALUE ? -1 : total;
    }

    private int findPrice(Map<Integer, List<Edge>> graph, int src, int dst, int k, int[][] memo) {

        if (src == dst) {
            //destination reached
            memo[src][k] = 0;
            return memo[src][k];
        }

        if (memo[src][k] != Integer.MAX_VALUE) {
            return memo[src][k];
        }

        if (graph.containsKey(src) && graph.get(src) != null) {
            if (k - 1 >= 0) {
                for (Edge child : graph.get(src)) {
                    int price = findPrice(graph, child.to, dst, k - 1, memo);
                    if (price != Integer.MAX_VALUE) {
                        memo[src][k] = Math.min(memo[src][k], child.weight + price);
                    }
                }
            }
        }

        return memo[src][k];
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


    public static void main(String... s) {

        CheapestFlightWithinKStops cheap = new CheapestFlightWithinKStops();
//        int n = 5;
//        int[][] edges = {{1, 2, 10}, {2, 0, 7}, {1, 3, 8}, {4,0,10}, {3,4,2}, {4,2,10}, {0,3,3}, {3,1,6}, {2,4,5}};
//        int src = 0, dst = 4, k = 1;

//        int n = 5;
//        int[][] edges = {{3, 0, 8}, {1, 4, 1}, {1, 0, 4}, {1, 3, 3}, {3, 4, 1}, {2, 3, 3}, {2, 0, 10}};
//        int src = 1, dst = 4, k = 4;

        int n = 3;
        int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0, dst = 2, k = 1;

        Objects.hash();
        System.out.println(cheap.findCheapestPrice(n, edges, src, dst, k));
    }

}
