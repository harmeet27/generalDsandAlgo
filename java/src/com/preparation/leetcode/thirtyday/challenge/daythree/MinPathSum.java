package com.preparation.leetcode.thirtyday.challenge.daythree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinPathSum {
    static HashMap<Position, Integer> dp = new HashMap();

    public static int minPathSum(int[][] grid) {
        findMinSum(grid, 0, 0);
        return dp.get(new Position(0, 0));
    }

    private static int findMinSum(int[][] grid, int i, int j) {

        Position pos = new Position(i, j);
        if (dp.containsKey(pos)) {
            return dp.get(pos);
        }

        if (i == grid.length && j == grid.length) {
            dp.put(pos, grid[i][j]);
            return grid[i][j];
        }


        List<Position> neighbour = addNeighbours(pos, grid);
        int min = 0;
        if (neighbour.size() > 0) {
            min = Integer.MAX_VALUE;
        }
        for (Position neigh : neighbour) {
            int minNow = findMinSum(grid, neigh.i, neigh.j);
            if (minNow < min) {
                min = minNow;
            }
        }

        dp.put(pos, grid[i][j] + min);
        return grid[i][j] + min;
    }

    private static List<Position> addNeighbours(Position pos, int[][] grid) {
        List<Position> posList = new LinkedList();

        if ((pos.j + 1) < grid[0].length) {
            Position posDown = new Position(pos.i, pos.j + 1);
            posList.add(posDown);
        }
        if ((pos.i + 1) < grid.length) {
            Position posRight = new Position(pos.i + 1, pos.j);
            posList.add(posRight);
        }


        return posList;
    }

    static class Position {
        int i;
        int j;

        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean equals(Object o) {
            Position p = (Position) o;
            return p.i == this.i && p.j == this.j;
        }

        public int hashCode() {
            return this.i + this.j;
        }
    }

    public static void main(String... s) {
//        int grid[][] = new int[][]{{1, 3, 1},
//                {1, 5, 1},
//                {4, 2, 1}};
        int grid[][] = new int[][]{{1, 2, 3},
                {4, 5, 6}};
        System.out.println(minPathSum(grid));
    }
}
