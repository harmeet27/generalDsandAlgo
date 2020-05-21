package com.preparation.leetcode.thirtyday.challenge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MinPathSumInMatrix {
    HashMap<Position, Integer> dp = new HashMap();

    public int minPathSum(int[][] grid) {
        findMinSum(grid, 0, grid.length - 1, grid[0].length - 1);
        return dp.get(new Position(0, 0));
    }

    private void findMinSum(int[][] grid, int sum, int i, int j) {

        if (i < 0 || j < 0) {
            return;
        }

        Position pos = new Position(i, j);
        sum = sum + grid[pos.i][pos.j];
        if (dp.containsKey(pos)) {
            if (sum < dp.get(pos)) {
                dp.put(pos, sum);

            }
            return;
        }

        dp.put(pos, sum);

        List<Position> neighbour = addNeighbours(pos, grid);
        for (Position neigh : neighbour) {
            findMinSum(grid, sum, neigh.i, neigh.j);
        }
    }

    List<Position> addNeighbours(Position pos, int[][] grid) {
        List<Position> posList = new LinkedList();
        if ((pos.i - 1) >= 0) {
            Position posRight = new Position(pos.i - 1, pos.j);
            posList.add(posRight);
        }
        if ((pos.j-1)>=0) {
            Position posDown = new Position(pos.i, pos.j - 1);
            posList.add(posDown);
        }

        return posList;
    }

    class Position {
        int i;
        int j;

        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean equals(Object o) {
             Position p = (Position)o;
            return p.i == this.i && p.j == this.j;
        }

        public int hashCode() {
            return this.i + this.j;
        }
    }

    public static void main(String[] s) {
        MinPathSumInMatrix matrix = new MinPathSumInMatrix();

//        int[][] grid = new int[][]{
//                {1, 3, 1},
//                {1, 5, 1},
//                {4, 2, 1}
//        };
//        int[][] grid = new int[][]{
//                {1, 2},
//                {1, 1}
//        };

        int[][] grid = new int[][]{
                {1, 2,5},
                {3,2,1}
        };
        matrix.minPathSum(grid);
    }
}
