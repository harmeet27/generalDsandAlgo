package com.preparation.algorithm.modifiedbinarysearch;

import java.util.Arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * <p>
 * <p>
 * SOl: find the nextGreatestToElement column number. ONce found, apply binary search in that row,colNo;
 */
public class FindAnElementInSortedMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int col = binarySearchColNextNearest(matrix, 0, matrix.length - 1, target);
        return col == -1 ? false : Arrays.binarySearch(matrix[col], target) < 0 ? false : true;

    }

    private int binarySearchColNextNearest(int[][] matrix, int start, int end, int target) {
        int lastColY = matrix[0].length - 1;
        int nextGreatest = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][lastColY] == target) {
                return mid;
            } else if (matrix[mid][lastColY] > target) {
                if (nextGreatest == -1) {
                    nextGreatest = mid;
                } else {
                    nextGreatest = matrix[mid][lastColY] > matrix[nextGreatest][lastColY] ? nextGreatest : mid;
                }
                end = mid - 1;
            } else if (matrix[mid][lastColY] < target) {
                start = mid + 1;
            }
        }
        return nextGreatest;

    }
}
