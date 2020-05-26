package com.preparation.leetcode.thirtyday.challenge.dayfour;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 * <p>
 * <p>
 * Approach:
 * 1. Bruteforce : for each val find the max Square and keep doing this 0(m*n*k)
 * <p>
 * 2. OPtimized(
 * 0(m*n))
 * create a new matrix and populate it with with first row and first col as it is.
 * For further population
 * chaeck if matrix[i][j]==1
 * <p>
 * if yes, then find the min of its smalles square and add + 1 to it
 * if no, polpulate 0 in the new matrix
 */

public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {

        //null matrix
        if (matrix == null) {
            return 0;
        }

        //empty matrix
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        //only column
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == '1') {
                    return 1;
                }
            }
            return 0;
        }

        //only row
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == '1') {
                    return 1;
                }
            }
            return 0;
        }


        char[][] sumMatrix = new char[matrix.length][matrix[0].length];
        int max = 0;
        //populating first row and first column
        for (int i = 0; i < matrix.length; i++) {
            sumMatrix[i][0] = matrix[i][0];
            if (matrix[i][0] == '1') {
                max = 1;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            sumMatrix[0][j] = matrix[0][j];
            if (matrix[0][j] == '1') {
                max = 1;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int upper = (sumMatrix[i - 1][j]) - '0';
                    int left = (sumMatrix[i][j - 1]) - '0';
                    int diagonal = (sumMatrix[i - 1][j - 1]) - '0';

                    int minFind = Math.min(upper, left);
                    minFind = Math.min(minFind, diagonal) + 1;
                    sumMatrix[i][j] = (char) (minFind + '0');
                    if (minFind > max) {
                        max = minFind;
                    }
                } else {
                    sumMatrix[i][j] = '0';
                }
            }
        }

        return max * max;

    }

    public static void main(String... s) {

//        char[][] grid = new char[][]{
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}
//        };

        char[][] grid = new char[][]{
                {'0', '1'},
                {'1', '0'}
        };

        System.out.println(maximalSquare(grid));
    }

}
