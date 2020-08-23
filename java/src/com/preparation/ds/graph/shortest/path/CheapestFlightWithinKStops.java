package com.preparation.ds.graph.shortest.path;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CheapestFlightWithinKStops {

    HashMap<Integer, List<Destination>> adjList = new HashMap<>();

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        for (int i = 0; i < flights.length; i++) {
            List<Destination> destinations = adjList.getOrDefault(flights[i][0], new LinkedList());
            destinations.add(new Destination(flights[i][1], flights[i][2]));
            adjList.put(flights[i][0], destinations);
        }

        int[][] memo = new int[n][K + 2];
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE));
        int total = findPrice(src,new Destination(src, 0), dst, K + 1, memo);
        return total == Integer.MAX_VALUE ? -1 : total;
        // return minSum==Integer.MAX_VALUE?-1:minSum;
    }

    private int findPrice(int src, Destination destination, int dst, int k, int[][] memo) {

        if (src == dst) {
            //destination reached
            memo[src][k] = 0;
            return memo[src][k];
        }

        if (memo[src][k] != Integer.MAX_VALUE) {
            return memo[src][k];
        }

        if (adjList.containsKey(src) && adjList.get(src) != null) {
            if (k - 1 >= 0) {
                for (Destination dest : adjList.get(src)) {
                    int price = findPrice(dest.destination,dest, dst, k - 1, memo);
                    if (price != Integer.MAX_VALUE) {
                        memo[src][k] = Math.min(memo[src][k], destination.cost + price);
                    }
                }
            }
        }

        return memo[src][k];
    }

    static class Destination {
        public int destination;
        public int cost;

        public Destination(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
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


        System.out.println(cheap.findCheapestPrice(n, edges, src, dst, k));
    }

}
