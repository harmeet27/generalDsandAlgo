package com.preparation.algorithm.traversing.iteratively;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Algorithm:
 * * 1. Created a Queue of nodes and visited array.
 * * 2. Insert the root in the queue.
 * * 3. Run a loop till the queue is not empty.
 * * 4. Pop the element from the queue and print the element.
 * * 5. For every adjacent and unvsisted node of current node, mark the node and insert it in the queue.
 * <p>
 * <p>
 * adList/adjMatrix --> findNeighbours() --> eficiency
 * <p>
 * Curretn BFS: E eges
 * 1,2
 * 1,3
 * 1,5
 * 2,3
 * 2,7
 * 3,4
 * <p>
 * 1 --> 2,3,5 (o(1))
 * 2 --> 3,7
 * 4 -->4
 * <p>
 * findNeightbours(integer) --> E >> V --> V   --> E+V
 * quue.addAll(findNeighbous(Integer))
 * visited:
 * HashSet<Integer>
 * <p>
 * Maze(n*m) --> matrx x , input , neighbour  --> o(1)
 * x+1,y
 * x-1,y
 * x,y+1
 * x,y-1
 * cell
 * Visited --> boolean[n][m]  true/false n,m cell
 * <p>
 * multiSources: List<Sources>
 * <p>
 * queue.add(if 2)
 * <p>
 * <p>
 * 0,1,2
 * 0,0,0
 * 0,2,1
 * <p>
 * 1--> fresh
 * 2--> rotten
 */
public class BFS {

    public static boolean solveSourceDestination(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                //i,j
                if (maze[i][j] == 2) {
                    //valid source
                    boolean found = shortestPathBFS(maze, i, j, 2);
                    if (found) {
                        return found;
                    }
                }

            }
        }

        return false;
    }


    public static boolean shortestPathBFS(int[][] maze, int x, int y, int destinationValue) {

        //visited
        //HashMap 1+"-/,"+4
        //int[][] 1,4 --> true

        boolean found = false;
        int rows = maze.length;//4
        int col = maze[0].length;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        //dry run
        while (!queue.isEmpty()) {
            Node removed = queue.poll();
            visited[removed.i][removed.j] = true;

            if (maze[removed.i][removed.j] == destinationValue) {

//                found = removed.count;
                found = true;
                break;
            }

            //add neightbours, visit

            List<Node> avialableNeightbours = neightbourNodes(maze, removed.i, removed.j);
            for (Node node : avialableNeightbours) {
                if (visited[node.i][node.j] == false) {
//                    node.distacnce = removed.distance+constant; //distance --> level , level , queue
                    queue.add(node);
                }
            }


        }


        return found;
    }

    private static class Node {
        int i;
        int j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static List<Node> neightbourNodes(int[][] maze, int x, int y) {
//        x+1,y
//                y+1,x
//               up,down  --> x,y --> x-1,y / x+1,y
//
        LinkedList<Node> neightbour = new LinkedList<>();
        neightbour.add(new Node(x + 1, y));
        neightbour.add(new Node(x - 1, y));
        neightbour.add(new Node(x, y + 1));
        neightbour.add(new Node(x, y - 1));
        return neightbour;

    }

    public static void main(String... s) {
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        shortestPathBFS(maze, 0, 0, 9);
    }


}
