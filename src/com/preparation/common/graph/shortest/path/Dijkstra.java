package com.preparation.common.graph.shortest.path;

import static com.preparation.common.graph.util.GraphUtil.*;

import java.util.*;


/**
 * 1
 * 4 4
 * 1 2 24
 * 1 4 20
 * 3 1 3
 * 4 3 12
 * 1
 */
public class Dijkstra {

    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases > 0) {
            int nodes = scanner.nextInt();
            int edges = scanner.nextInt();
            String[][] input = new String[edges][3];
            int i = 0;
            while (i < edges) {
                input[i][0] = scanner.next();
                input[i][1] = scanner.next();
                input[i][2] = scanner.next();
                i++;
            }

            int source = scanner.nextInt();
            PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
            HashMap<Integer, List<Node>> adjList = obtainAdjacencyListAdirected(nodes, input);
            HashMap<Integer, Integer> records = prepareInitialData(nodes, adjList, source);
            applyDijkstra(source, queue, adjList, records);
            testCases--;
        }
    }

    private static void applyDijkstra(int source, PriorityQueue<Node> queue, HashMap<Integer, List<Node>> adjList, HashMap<Integer, Integer> records) {
        HashSet<Integer> history = new HashSet<>();
        history.add(source);
        queue.addAll(adjList.get(source));
        while (history.size() != records.size() && !queue.isEmpty()) {
            Node minNode = queue.poll();
            if (!history.contains(minNode.to)) {
                history.add(minNode.to);
                List<Node> children = adjList.get(minNode.to);
                for (Node child : children) {
                    child.weight += minNode.weight;  //updating all children weight with new weight till point
                    queue.add(child);
                    //applying relaxation
                    if (child.weight < records.get(child.to)) {
                        records.put(child.to, child.weight);
                    }
                }
            }

        }
        System.out.println(records.toString());
    }

    private static HashMap<Integer, Integer> prepareInitialData(int nodes, HashMap<Integer, List<Node>> adjList, int source) {
        HashMap<Integer, Integer> distanceRecord = new HashMap<>();

        //Initialize all records with infinte values in records
        for (int i = 1; i <= nodes; i++) {
            distanceRecord.put(i, Integer.MAX_VALUE);
        }

        //Adding direct nodes weight
        //Consider cases if same from:to has different weigth we have to pick smalles weight
        List<Node> data = adjList.get(source);
        for (Node node : data) {
            if (distanceRecord.get(node.to) > node.weight) {
                distanceRecord.put(node.to, node.weight);
            } else {
                distanceRecord.put(node.to, node.weight);
            }
        }
        return distanceRecord;
    }

    static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.weight - o2.weight;
        }
    }

}
