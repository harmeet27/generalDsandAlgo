package com.preparation.common.graph.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GraphUtil<E, V> {

    //to obtain adjListOfUndirected graph, in the String[][] only add 2 Nodes for each edge:
    //1. with from to weight
    //2. with to from weight
    public static HashMap<Integer, List<Node>> obtainAdjacencyList(int totalNodes, String[][] edgesWithWeight) {
        List<Node> nodes = new LinkedList<>();
        HashMap<Integer, List<Node>> ajdList = new HashMap<>();
        for (int i = 0; i < edgesWithWeight.length; i++) {
            Node node = new Node(Integer.parseInt(edgesWithWeight[i][0]), Integer.parseInt(edgesWithWeight[i][1]), Integer.parseInt(edgesWithWeight[i][2]));
            nodes.add(node);
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

    public static HashMap<Integer, List<Node>> obtainAdjacencyListAdirected(int totalNodes, String[][] edgesWithWeight) {
        List<Node> nodes = new LinkedList<>();
        HashMap<Integer, List<Node>> ajdList = new HashMap<>();
        for (int i = 0; i < edgesWithWeight.length; i++) {
            Node node = new Node(Integer.parseInt(edgesWithWeight[i][0]), Integer.parseInt(edgesWithWeight[i][1]), Integer.parseInt(edgesWithWeight[i][2]));
            Node secondNode = new Node(Integer.parseInt(edgesWithWeight[i][1]), Integer.parseInt(edgesWithWeight[i][0]), Integer.parseInt(edgesWithWeight[i][2]));
            nodes.add(node);
            nodes.add(secondNode);
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

    //adjacency matrix

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
            return from + to + weight;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            boolean success = (this.from == ((Node) obj).from) && (this.to == ((Node) obj).to) && (this.weight == ((Node) obj).weight);
            return success;
        }

    }

}
