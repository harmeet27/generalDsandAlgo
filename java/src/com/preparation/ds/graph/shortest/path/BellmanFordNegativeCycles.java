package com.preparation.ds.graph.shortest.path;

import com.preparation.ds.graph.model.EdgeFromNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * can find -ve cycle
 * can find shortest path in weighted graph with +ve and -ve weights.
 * <p>
 * 2 times run Dp algorithm (E*V)
 * <p>
 * WONT WORK ON DISCONNECTED GRAPH
 */
public class BellmanFordNegativeCycles {

    public int[] bellmanFord(int start, Map<Integer, List<EdgeFromNode<Integer>>> graph) {
        int[] distance = new int[graph.size() + 1]; //not considering 0
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for (int fromVertex = 1; fromVertex <= graph.size(); fromVertex++) {
            for (EdgeFromNode<Integer> edge : graph.get(fromVertex)) {
                int weightToReachThisEdge = distance[fromVertex];
                if (weightToReachThisEdge == Integer.MAX_VALUE) continue;
                if (weightToReachThisEdge + edge.weight < distance[edge.to]) {
                    distance[edge.to] = weightToReachThisEdge + edge.weight;
                }
            }
        }
        return distance;
    }

    public void detectNegativeCycles(Map<Integer, List<EdgeFromNode<Integer>>> graph) {
        if (graph == null || graph.size() <= 1) {
            return;
        }

        Iterator<Integer> it = graph.keySet().iterator();
        int randomVertexAsStart = it.next();
        int[] distance = bellmanFord(randomVertexAsStart, graph);

        for (int fromVertex = 1; fromVertex <= graph.size(); fromVertex++) {
            for (EdgeFromNode<Integer> edge : graph.get(fromVertex)) {
                int weightToReachThisEdge = distance[fromVertex];
                if (weightToReachThisEdge == Integer.MAX_VALUE) continue;
                if (weightToReachThisEdge + edge.weight < distance[edge.to]) {
                    distance[edge.to] = Integer.MIN_VALUE;
                }
            }
        }

        List<Integer> negativeCycleVertices = new LinkedList<>();
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MIN_VALUE) {
                negativeCycleVertices.add(i);
            }
        }
        System.out.println();
        System.out.println("-----------------------NEGATIVE CYCLE IF ANY-------------------");
        negativeCycleVertices.stream().forEach(element -> System.out.print(element + " | "));
    }


    public static void main(String... s) {
        Map<Integer, List<EdgeFromNode<Integer>>> graph2 = new HashMap<>();
        graph2.put(1, Arrays.asList(new EdgeFromNode<Integer>(1, 2, 4), new EdgeFromNode<Integer>(1, 3, 4)));
        graph2.put(2, new LinkedList<>());
        graph2.put(3, Arrays.asList(new EdgeFromNode<Integer>(3, 5, 4), new EdgeFromNode<Integer>(3, 6, -2)));
        graph2.put(4, Arrays.asList(new EdgeFromNode<Integer>(4, 3, 2), new EdgeFromNode<Integer>(4, 1, 3)));
        graph2.put(5, Arrays.asList(new EdgeFromNode<Integer>(5, 4, 1)));
        graph2.put(6, Arrays.asList(new EdgeFromNode<Integer>(6, 2, 3), new EdgeFromNode<Integer>(6, 5, -3)));
        System.out.println();
        BellmanFordNegativeCycles bellmanFordNegativeCycles = new BellmanFordNegativeCycles();
        int[] distance = bellmanFordNegativeCycles.bellmanFord(1, graph2);
        System.out.println("------------------------------DISTANCE----------------------------");
        Arrays.stream(distance).forEach(element -> System.out.print("" + element + " | "));

        bellmanFordNegativeCycles.detectNegativeCycles(graph2);
    }
}
