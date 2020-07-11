package com.preparation.algorithm.dp.grokkingDPPattern.unboundedknapsack;

import java.util.Arrays;

/**
 * Cutting a Rod | DP-13
 * <p>
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * <p>
 * <p>
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * <p>
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 * <p>
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 */
public class RodCutting {

    public static void main(String... s) {
        int length = 8;
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};

//        int length = 8;
//        int arr[] = new int[]{3, 5, 8, 9, 10, 17, 17, 20};

        int[][] memo = new int[arr.length + 1][length + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        System.out.println(cutMaxPriceRod(arr, length, 0, 0, memo));
    }

    private static int cutMaxPriceRod(int[] arr, int length, int index, int sum, int[][] memo) {

        if (memo[index][length] != -1) {
            return memo[index][length];
        }

        if (length == 0) {
            return sum;
        }

        if (index == arr.length) {
            return 0;
        }

        int current = 0;
        for (int i = 0; i < arr.length; i++) {
            if (length - (i + 1) >= 0) {
                current = Math.max(current, cutMaxPriceRod(arr, length - (i + 1), i, sum + arr[i], memo));
            }
        }
        memo[index][length] = current;
        return current;
    }
}
