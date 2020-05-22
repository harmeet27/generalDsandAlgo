package com.preparation.common.graph;

import java.io.IOException;
import java.util.*;

public class JourneyMoon {

    private static HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
    private static HashMap<Integer, Integer> cluster = new HashMap<>();
    private static HashMap<Integer, Boolean> visited = new HashMap<>();

    static int journeyToMoon(int n, int[][] astronaut, boolean yes) {
        prepareAdjList(astronaut);
        clusterAll();
        return findTheAstronauts(n, astronaut);
    }

    private static void clusterAll() {
        Set<Map.Entry<Integer, Set<Integer>>> enteries = adjList.entrySet();
        for (Map.Entry<Integer, Set<Integer>> entry : enteries) {
            //take 1 entry, prepare queue for that and remove from map too.
            //when next entry comes

            Integer parentAstronaut = entry.getKey();

            if (visited.containsKey(parentAstronaut)) {
                continue;
            }
            visited.put(parentAstronaut, true);
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> children = entry.getValue();
            cluster.put(parentAstronaut, 1);
            queue.addAll(children);
            while (!queue.isEmpty()) {
                int id = queue.poll();
                if (!visited.containsKey(id)) {
                    cluster.put(parentAstronaut, cluster.get(parentAstronaut) + 1);
                    if (adjList.get(id) != null && adjList.get(id).size() > 0) {
                        queue.addAll(adjList.get(id));
                    }
                    visited.put(id, true);
                }
            }
        }
    }

    private static void prepareAdjList(int[][] astronaut) {

        for (int i = 0; i < astronaut.length; i++) {
            if (adjList.containsKey(astronaut[i][0])) {
                adjList.get(astronaut[i][0]).add(astronaut[i][1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(astronaut[i][1]);
                adjList.put(astronaut[i][0], set);
            }
            addSecondValue(astronaut[i][0], astronaut[i][1]);
        }
    }

    private static void addSecondValue(int first, int second) {
        if (adjList.containsKey(second)) {
            adjList.get(second).add(first);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(first);
            adjList.put(second, set);
        }
    }

    private static int findTheAstronauts(int n, int astronaut[][]) {

        //populate remianing
        int remaining = n - adjList.size();
        for (int i = 0; i < remaining; i++) {
            cluster.put(i - remaining, 1);
        }

        int product = 0;
        int countrySum = n;

        Set<Map.Entry<Integer, Integer>> enteries = cluster.entrySet();
        for (Map.Entry<Integer, Integer> entry : enteries) {
            product = product + (entry.getValue() * (countrySum - entry.getValue()));
            countrySum = countrySum - entry.getValue();
        }

        return product;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        int result = journeyToMoon(n, astronaut, true);
        System.out.println(String.valueOf(result));
        System.out.println();
        scanner.close();
    }
}
