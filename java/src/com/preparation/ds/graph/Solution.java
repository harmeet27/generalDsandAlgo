package com.preparation.ds.graph;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String path=System.getenv("OUTPUT_PATH");
        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        for (int i = 0; i < gEdges; i++) {
            String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            gFrom.add(Integer.parseInt(gFromToWeight[0]));
            gTo.add(Integer.parseInt(gFromToWeight[1]));
            gWeight.add(Integer.parseInt(gFromToWeight[2]));
        }

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.
        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */
    static class PathNode {
        int from;
        int to;

        PathNode(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static HashMap<Integer, Integer> visited = new HashMap();

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        TreeMap<Integer, PathNode> adjList = new TreeMap();
        for (int i = 0; i < gFrom.size(); i++) {
            PathNode node = new PathNode(gFrom.get(i), gTo.get(i));
            adjList.put(gWeight.get(i), node);
        }

        HashMap<Integer, HashSet<Integer>> mst = new HashMap();
        int sum = 0;
        Set<Map.Entry<Integer, PathNode>> entries = adjList.entrySet();
        for (Map.Entry<Integer, PathNode> entry : entries) {
            Integer weight = entry.getKey();
            PathNode node = entry.getValue();
            boolean cycle = checkCycleFormed(mst, node);
            if (cycle == false) {
                if (mst.containsKey(node.from)) {
                    mst.get(node.from).add(node.to);
                    sum=sum+weight;
                } else {
                    HashSet<Integer> children = new HashSet();
                    children.add(node.to);
                    mst.put(node.from, children);
                    sum=sum+weight;
                }
            }

        }
        return sum;
    }


    static boolean checkCycleFormed(HashMap<Integer, HashSet<Integer>> mst, PathNode node) {
        HashMap<Integer, HashSet<Integer>> cloned = new HashMap();
        cloned.putAll(mst);
        if (cloned.containsKey(node.from)) {
            cloned.get(node.from).add(node.to);
        } else {
            HashSet<Integer> values = new HashSet();
            values.add(node.to);
            cloned.put(node.from, values);
        }
        return determineCycle(cloned, node);

    }

    static boolean determineCycle(HashMap<Integer, HashSet<Integer>> mst, PathNode node) {
        Queue<Integer> queue = new LinkedList();
        visited.put(node.from, visited.containsKey(node.from) ? visited.get(node.from) : -1);
        queue.add(node.to);
        boolean cycle = false;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (visited.containsKey(poll) && node.from != visited.get(poll)) {
                cycle = true;
                break;
            }

            if (mst.containsKey(poll)) {
                queue.addAll(mst.get(poll));
            } else {
                mst.put(poll, new HashSet());
            }
            visited.put(node.to,node.from);
        }
        return cycle;
    }
}

