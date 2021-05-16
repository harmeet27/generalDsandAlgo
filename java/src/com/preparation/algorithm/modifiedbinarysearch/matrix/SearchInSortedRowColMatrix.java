package com.preparation.algorithm.modifiedbinarysearch.matrix;

/**
 * https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 *
 * Search in a row wise and column wise sorted matrix
 * Difficulty Level : Medium
 * Last Updated : 14 May, 2021
 * Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order. The designed algorithm should have linear time complexity.
 *
 * Example:
 *
 * Input: mat[4][4] = { {10, 20, 30, 40},
 *                       {15, 25, 35, 45},
 *                       {27, 29, 37, 48},
 *                       {32, 33, 39, 50}};
 *               x = 29
 * Output: Found at (2, 1)
 * Explanation: Element at (2,1) is 29
 *
 * Input : mat[4][4] = { {10, 20, 30, 40},
 *                       {15, 25, 35, 45},
 *                       {27, 29, 37, 48},
 *                       {32, 33, 39, 50}};
 *               x = 100
 * Output : Element not found
 * Explanation: Element 100 is not found
 *
 *
 * Efficient Solution
 *
 * Approach: The simple idea is to remove a row or column in each comparison until an element is found. Start searching from the top-right corner of the matrix. There are three possible cases.
 * The given number is greater than the current number: This will ensure, that all the elements in the current row are smaller than the given number as the pointer is already at the right-most element and the row is sorted. Thus, the entire row gets eliminated and continues the search on the next row. Here elimination means that row needs not be searched.
 * The given number is smaller than the current number: This will ensure, that all the elements in the current column are greater than the given number. Thus, the entire column gets eliminated and continues the search on the previous column i.e. the column at the immediate left.
 * The given number is equal to the current number: This will end the search.
 */
public class SearchInSortedRowColMatrix {

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Write your code here.
        if (matrix == null || matrix.length == 0) {
            return new int[]{-1, -1};
        }

        //start from the TopRight element of the matrix;
        int chosenI = 0;
        int chosenJ = matrix[0].length - 1;

        while (chosenI < matrix.length && chosenJ >= 0) {
            int element = matrix[chosenI][chosenJ];
            if (element == target) {
                return new int[]{chosenI, chosenJ};
            } else if (element > target) {
                //ignore current column
                chosenJ--;
            } else {
                //ignore row
                chosenI++;
            }
        }
        return new int[]{-1, -1};
    }
}
