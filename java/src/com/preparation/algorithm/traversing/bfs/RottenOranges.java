package com.preparation.algorithm.traversing.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        Queue<Node> queue = new LinkedList();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {

                    visited[i][j] = true;
                    queue.add(new Node(i, j, 0));
                }
            }
        }


        int maxMins = 0;
        while (!queue.isEmpty()) {
            Node popped = queue.poll();
            if (maxMins < popped.mins) {
                maxMins = popped.mins;
            }

            List<Node> adjacent = findNeighbours(grid, popped);
            for (Node node : adjacent) {
                if (grid[node.i][node.j] != 0 && visited[node.i][node.j] != true) {

                    visited[node.i][node.j] = true;
                    grid[node.i][node.j] = 2;
                    queue.add(node);
                }
            }


        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return maxMins;
    }

    public List<Node> findNeighbours(int[][] grid, Node popped) {
        List<Node> list = new LinkedList();
        int i = popped.i;
        int j = popped.j;


        if (i - 1 >= 0) {
            list.add(new Node(i - 1, j, popped.mins + 1));
        }
        if (i + 1 < grid.length) {
            list.add(new Node(i + 1, j, popped.mins + 1));
        }
        if (j - 1 >= 0) {
            list.add(new Node(i, j - 1, popped.mins + 1));
        }
        if (j + 1 < grid[0].length) {
            list.add(new Node(i, j + 1, popped.mins + 1));
        }
        return list;

    }

    class Node {
        int i;
        int j;
        int mins;

        Node(int i, int j, int mins) {
            this.i = i;
            this.j = j;
            this.mins = mins;
        }
    }
}
