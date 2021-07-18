package com.preparation.ds.graph.shortest.path;

import com.preparation.ds.graph.model.Edge;
import com.preparation.ds.graph.model.EdgeFromNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Advancement over Lazy Dijkstra (meaning performing queue processing till it's empty)
 * <p>
 * Advancement: We can break from queue when the target node is traversed.(as that's what we
 * are interested in for shortest distance from source and we do not to find for all)
 * We call it Eager Disjkstra
 * <p>
 * <p>
 * is a Greedy Algorithm.
 */
public class Dijkstra {

    //will return the shortest distance of each node from source.
    public static int[] dijkstra(int start, int end, Map<Integer, List<Edge>> graph) {
        int distance[] = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean visited[] = new boolean[graph.size()];

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>((first, second) -> {
            if (first.weight < second.weight) return -1;
            else if (first.weight == second.weight) return 0;
            return 1;
        });

        distance[start] = 0;
        queue.add(new Edge(0, 0));

        while (!queue.isEmpty()) {
            Edge traversed = queue.poll();
            int fromNode = traversed.to;
            int existingWeight = traversed.weight;
            if (visited[fromNode]) {
                continue;
            }
            visited[fromNode] = true;
            if (graph.get(fromNode) != null) {
                for (Edge child : graph.get(fromNode)) {
                    int totalWeightToReachChild = existingWeight + child.weight;
                    if (distance[child.to] > totalWeightToReachChild) { //already a smaller path encountered , no need to consider all path using this path (that is why else not considered)
                        distance[child.to] = totalWeightToReachChild;
                        child.weight = totalWeightToReachChild;
                        queue.add(child);
                    }
                }
            }
        }
        return distance;
    }

    //will return the path
    public static List<Integer> dijkstraShortestPath(int start, int end, Map<Integer, List<EdgeFromNode<Integer>>> graph) {

        int[] parent = new int[graph.size()];
        int[] distance = new int[graph.size()];
        boolean visited[] = new boolean[graph.size()];

        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<EdgeFromNode<Integer>> queue = new PriorityQueue<EdgeFromNode<Integer>>((first, second) -> {
            if (first.weight < second.weight) return -1;
            else if (first.weight == second.weight) return 0;
            return 1;
        });

        distance[start] = 0;
        queue.add(new EdgeFromNode<>(0, 0, 0));

        while (!queue.isEmpty()) {
            EdgeFromNode<Integer> traversed = queue.poll();
            int fromNode = traversed.to;
            int existingWeight = traversed.weight;
            if (visited[fromNode]) {
                continue;
            }
            visited[fromNode] = true;
            if (graph.get(fromNode) != null) {
                for (EdgeFromNode<Integer> child : graph.get(fromNode)) {
                    int totalWeightToReachChild = existingWeight + child.weight;
                    if (distance[child.to] > totalWeightToReachChild) { //already a smaller path encountered , no need to consider all path using this path (that is why else not considered)
                        parent[child.to] = child.from;
                        distance[child.to] = totalWeightToReachChild;
                        child.weight = totalWeightToReachChild;
                        queue.add(child);
                    }
                }
            }
        }

        Arrays.stream(distance).forEach(element -> System.out.print(element + " | "));
        System.out.println();
        Arrays.stream(parent).forEach(element -> System.out.print(element + " | "));

        //obtain path from parent indexes of each node.
        List<Integer> path = new LinkedList<>();
        int index = end;
        path.add(end);
        while (index != start) {
            index = parent[index];
            path.add(index);
        }

        //since we are storing in reverse order
        Collections.reverse(path);
        return path;
    }

    public static void main(String... s) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(new Edge(1, 3), new Edge(2, 6)));
        graph.put(1, Arrays.asList(new Edge(3, 4), new Edge(4, 11)));
        graph.put(2, Arrays.asList(new Edge(3, 8), new Edge(6, 11)));
        graph.put(3, Arrays.asList(new Edge(4, 4), new Edge(5, 5), new Edge(6, 2)));
        graph.put(4, Arrays.asList(new Edge(7, 9)));
        graph.put(5, Arrays.asList(new Edge(7, 1)));
        graph.put(6, Arrays.asList(new Edge(7, 2)));
        graph.put(7, new LinkedList<>());
        int[] distance = dijkstra(0, 7, graph);
        Arrays.stream(distance).forEach(element -> System.out.print("" + element + " | "));


        //Print path shortest
        Map<Integer, List<EdgeFromNode<Integer>>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(new EdgeFromNode<Integer>(0, 1, 3), new EdgeFromNode<Integer>(0, 2, 6)));
        graph2.put(1, Arrays.asList(new EdgeFromNode<Integer>(1, 3, 4), new EdgeFromNode<Integer>(1, 4, 11)));
        graph2.put(2, Arrays.asList(new EdgeFromNode<Integer>(2, 3, 8), new EdgeFromNode<Integer>(2, 6, 11)));
        graph2.put(3, Arrays.asList(new EdgeFromNode<Integer>(3, 4, 4), new EdgeFromNode<Integer>(3, 5, 5), new EdgeFromNode(3, 6, 2)));
        graph2.put(4, Arrays.asList(new EdgeFromNode<Integer>(4, 7, 9)));
        graph2.put(5, Arrays.asList(new EdgeFromNode<Integer>(5, 7, 1)));
        graph2.put(6, Arrays.asList(new EdgeFromNode<Integer>(6, 7, 2)));
        graph2.put(7, new LinkedList<>());
        System.out.println();
        List<Integer> path = dijkstraShortestPath(0, 7, graph2);
        System.out.println();
        path.stream().forEach(element -> System.out.print("" + element + " --> "));

    }
}
