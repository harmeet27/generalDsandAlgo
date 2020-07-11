package com.preparation.ds.graph.shortest.path.hackerrank;
/**
 * 1
 * 5 7
 * 1 2 5
 * 1 2 4
 * 1 2 2
 * 1 4 19
 * 1 4 13
 * 1 3 3
 * 3 5 5
 * 1
 */

import java.io.IOException;
import java.util.*;

public class Dijkstra {

    public static void main(String s[]) throws IOException {
//        Scanner scanner = new Scanner(new FileInputStream(new File("/Users/oyo/Desktop/DijkstraInput.txt")));
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        HashMap<Node, Integer> repeatedEdges = new HashMap<>();

        while (testCases > 0) {
            int nodes = scanner.nextInt();
            int edges = scanner.nextInt();
            int[][] input = new int[edges][3];
            int j = 0;
            while (j < edges) {
                input[j][0] = scanner.nextInt();
                input[j][1] = scanner.nextInt();
                input[j][2] = scanner.nextInt();
                Node node = new Node(input[j][0], input[j][1], input[j][2]);
                Node secondNode = new Node(input[j][1], input[j][0], input[j][2]);
                j++;
                if (repeatedEdges.containsKey(node)) {
                    if (repeatedEdges.get(node) > node.weight) {
                        repeatedEdges.put(node, node.weight);
                    }
                } else {
                    repeatedEdges.put(node, node.weight);
                }
                if (repeatedEdges.containsKey(secondNode)) {
                    if (repeatedEdges.get(secondNode) > secondNode.weight) {
                        repeatedEdges.put(secondNode, secondNode.weight);
                    }
                } else {
                    repeatedEdges.put(secondNode, secondNode.weight);
                }

            }

            int source = scanner.nextInt();
            int[] result = shortestReach(repeatedEdges, nodes, input, source);

            for (int i = 0; i < result.length; i++) {
                System.out.print(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
            testCases--;
        }
    }

    static int[] shortestReach(HashMap<Node, Integer> repeatedEdges, int nodes, int[][] input, int source) {

        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        HashMap<Integer, List<Node>> adjList = obtainAdjacencyListAdirected(repeatedEdges, nodes, input);
        HashMap<Integer, Integer> records = prepareInitialData(nodes, adjList, source);
        applyDijkstra(source, queue, adjList, records);

        List<Integer> result = new LinkedList();
        for (int i = 1; i <= nodes; i++) {
            if (i == source) {
                continue;
            }

            if (records.get(i) == Integer.MAX_VALUE) {
                result.add(-1);
            } else {
                result.add(records.get(i));
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static class Node {
        public int from;
        public int to;
        public int weight;

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int hashCode() {
            return from + to;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            boolean success = (this.from == ((Node) obj).from) && (this.to == ((Node) obj).to);
            return success;
        }

    }

    public static HashMap<Integer, List<Node>> obtainAdjacencyListAdirected(HashMap<Node, Integer> repeatedEdges, int totalNodes, int[][] edgesWithWeight) {
        List<Node> nodes = new LinkedList<>();
        HashMap<Integer, List<Node>> ajdList = new HashMap<>();
//        for (int i = 0; i < edgesWithWeight.length; i++) {
//            Node node = new Node(edgesWithWeight[i][0], edgesWithWeight[i][1], edgesWithWeight[i][2]);
//            Node secondNode = new Node(edgesWithWeight[i][1], edgesWithWeight[i][0], edgesWithWeight[i][2]);
//            nodes.add(node);
//            nodes.add(secondNode);
//        }

        for (Map.Entry<Node, Integer> repeated : repeatedEdges.entrySet()) {
            nodes.add(new Node(repeated.getKey().from, repeated.getKey().to, repeated.getValue()));
        }

        //adding all nodes ranging from 0 to number of nodes-1
        int n = 0;
        while (n < totalNodes) {
            ajdList.put(n, new LinkedList());
            n++;
        }

        for (Node node : nodes) {
            if (ajdList.containsKey(node.from)) {
                ajdList.get(node.from).add(node);
            } else {
                LinkedList<Node> listNodes = new LinkedList<>();
                listNodes.add(node);
                ajdList.put(node.from, listNodes);
            }
        }

        return ajdList;
    }

    private static HashMap<Integer, Integer> prepareInitialData(int nodes, HashMap<Integer, List<Node>> adjList, int source) {
        HashMap<Integer, Integer> distanceRecord = new HashMap<>();

        //Initialize all records with infinte values in records
        for (int i = 1; i <= nodes; i++) {
            // if(i!=source){
            distanceRecord.put(i, Integer.MAX_VALUE);
            // }
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
                    child.weight += minNode.weight;
                    queue.add(child);
                    //applying relaxation
                    if (child.weight < records.get(child.to)) {
                        records.put(child.to, child.weight);
                    }
                }
            }

        }
//        System.out.println(records.toString());
    }
}
