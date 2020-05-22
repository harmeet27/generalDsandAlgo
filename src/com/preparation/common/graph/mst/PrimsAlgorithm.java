package com.preparation.common.graph.mst;

import java.util.*;
import java.util.stream.IntStream;

/**
 *
 * 1. Select the source
 * 2. From source, select the min element and the neighbouring in queue(connected neighbournig)
 * 3. Keep selecting the min element for N-1 times as in a connected graph there can be N-1 edges min.
 * 4. Make sure we are not visiting a node again.
 * 5. If similar values are there sleect any
 *
 *
 * 5 6
 * 1 2 3
 * 1 3 4
 * 4 2 6
 * 5 2 2
 * 2 3 5
 * 3 5 7
 */


public class PrimsAlgorithm {

    public static void main(String... s) {
        Scanner scan = new Scanner(System.in);


        int gNodes = scan.nextInt();
        int gEdges = scan.nextInt();

        List<Node> nodes = new LinkedList();

        IntStream.range(0, gEdges).forEach(i -> {
            int[] gFromToWeight = new int[3];
            gFromToWeight[0] = Integer.parseInt(scan.next());
            gFromToWeight[1] = Integer.parseInt(scan.next());
            gFromToWeight[2] = Integer.parseInt(scan.next());
            nodes.add(new Node(gFromToWeight[0], gFromToWeight[1], gFromToWeight[2]));
            nodes.add(new Node(gFromToWeight[1], gFromToWeight[0], gFromToWeight[2]));
        });

        HashMap<Integer, List<Node>> graph = prepareGraph(gNodes, nodes);
        Collections.sort(nodes, new NodeComparator());
        int cost = applyPrimsWithSource(1, gNodes, graph, nodes);
        System.out.println(cost);

        scan.close();

    }

    private static int applyPrims(int gNodes, HashMap<Integer, List<Node>> graph, List<Node> minNodes) {

        int total = gNodes - 1;
        Node min = minNodes.get(0);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(min.from);

        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        queue.addAll(graph.get(min.from));
        int sum = 0;
        while (total > 0 && !queue.isEmpty()) {
            Node newMin = queue.poll();
            if (visited.contains(newMin.to)) {
                continue;
            } else {
                sum = sum + newMin.weight;
                if (graph.get(newMin.to) != null) {
                    queue.addAll(graph.get(newMin.to));
                }
            }
            visited.add(newMin.to);
            total--;
        }

        return sum;


    }

    private static HashMap<Integer, List<Node>> prepareGraph(int gNodes, List<Node> nodes) {
        HashMap<Integer, List<Node>> ajdList = new HashMap<>();
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


    static class Node {
        int from;
        int to;
        int weight;

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int hashCode() {
            return from + to + weight;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            boolean success = (this.from == ((Node) obj).from) && (this.to == ((Node) obj).to) && (this.weight == ((Node) obj).weight);
            return success;
        }

    }

    static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.weight - o2.weight;
        }
    }

    private static int applyPrimsWithSource(int start, int gNodes, HashMap<Integer, List<Node>> graph, List<Node> minNodes) {

        int total = gNodes - 1;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);

        System.out.println("Visited " + start);
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        queue.addAll(graph.get(start));
        int sum = 0;
        while (total > 0 && !queue.isEmpty()) {
            Node newMin = queue.poll();
            if (visited.contains(newMin.to)) {
                continue;
            } else {
                System.out.println("Visited " + newMin.to);
                sum = sum + newMin.weight;
                if (graph.get(newMin.to) != null) {
                    queue.addAll(graph.get(newMin.to));
                }
            }
            visited.add(newMin.to);
            total--;
        }

        return sum;


    }
}
