package com.preparation.common.graph;

import java.io.IOException;
import java.util.*;

public class ShortestReach {

    // Complete the bfs function below.

    static class Node {
        int data;
        int level;

        public Node(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    static HashMap<Integer, HashSet<Integer>> history;

    static int[] bfs(int n, int m, int[][] edges, int s) {
        history = new HashMap<>();
        int values[] = new int[n];
        for (int i = 0; i < edges.length; i++) {
            add(edges[i][0], edges[i][1]);
        }
        HashMap<Integer, Boolean> visited = new HashMap();
        Queue<Node> queue = new LinkedList();
        for (int i = 0; i < n; i++) {
            values[i] = -1;
        }
        values[s - 1] = 0;
        if (!history.containsKey(s)) {
            return values;
        }

        Node sourceNode = new Node(s, 0);
        queue.add(sourceNode);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (!visited.containsKey(poll.data)) {
                visited.put(poll.data, true);
                values[poll.data - 1] = 6 * poll.level;
                if (history.containsKey(poll.data)) {
                    int i = 0;
                    HashSet<Integer> set = history.get(poll.data);
                    for(Integer setValue: set){
                        if(setValue>m){
                            i++;
                            continue;
                        }
                        Node tempNode = new Node(setValue, poll.level + 1);
                        queue.add(tempNode);
                        i++;
                    }
                }
            }
        }
        int[] result = new int[values.length - 1];
        int j = 0;
        for (int i : values) {
            if (i != 0) {
                result[j] = i;
                j++;
            }
        }
        return result;
    }


    public static void add(int s, int t) {
        if (history.containsKey(s)) {
            history.get(s).add(t);
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(t);
            history.put(s, set);
        }
        if (history.containsKey(t)) {
            history.get(t).add(s);
        } else {
            HashSet<Integer> set = new HashSet();
            set.add(s);
            history.put(t, set);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                System.out.println(String.valueOf(result[i]));
                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
