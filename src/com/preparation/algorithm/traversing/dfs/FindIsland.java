package com.preparation.algorithm.traversing.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 * <p>
 * <p>
 * <p>
 * ALGO:
 * traverse each of the cell , if one encountered, perform a DFS and replace all connecting 1 with 0.
 * and keep repeating above step for each cell.
 */
public class FindIsland {

    static int findIslands(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    dfsRemove1(arr, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfsRemove1(int[][] arr, int i, int j) {
        Stack<String> s = new Stack();
        HashSet<String> visited = new HashSet<>();
        s.add(i + "-" + j);
        while (!s.isEmpty()) {
            String[] element = s.pop().split("-");
            int row = Integer.parseInt(element[0]);
            int column = Integer.parseInt(element[1]);
            arr[row][column] = 0;
            if (visited.contains(row + "-" + column)) {
                continue;
            }
            visited.add(row + "-" + column);

            s.addAll(findNeighboursWith1(arr, row, column));
        }
    }

    private static List<String> findNeighboursWith1(int[][] arr, int i, int j) {
        List<String> neighbours = new LinkedList<>();

        //moving down and inserting only if it is 1
        if ((i + 1) < arr.length) {
            if (arr[i + 1][j] == 1) {
                neighbours.add((i + 1) + "-" + j);
            }
        }
        //moving up and inserting only if it is 1
        if ((i - 1) >= 0) {
            if (arr[i - 1][j] == 1) {
                neighbours.add((i - 1) + "-" + j);
            }
        }
        //moving right and inserting only if it is 1
        if ((j + 1) < arr[0].length) {
            if (arr[i][j + 1] == 1) {
                neighbours.add(i + "-" + (j + 1));
            }
        }

        //moving left and inserting only if it is 1
        if ((j - 1) >= 0) {
            if (arr[i][j - 1] == 1) {
                neighbours.add(i + "-" + (j - 1));
            }
        }

        return neighbours;
    }

    public static void main(String... s) {
//        int arr[][] = new int[][]
//                {
//                        {1, 1, 0, 0, 0},
//                        {1, 1, 0, 0, 0},
//                        {0, 0, 1, 0, 0},
//                        {0, 0, 0, 1, 1}
//                };

//        int arr[][] = new int[][]
//                {
//                        {1, 1, 1},
//                        {0, 1, 0},
//                        {1, 1, 1}
//                };

        int arr[][] = new int[][]
                {
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 1, 1, 0, 1}
                };
        System.out.println(findIslands(arr));
    }
}
