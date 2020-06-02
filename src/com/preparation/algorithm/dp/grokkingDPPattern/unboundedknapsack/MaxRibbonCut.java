package com.preparation.algorithm.dp.grokkingDPPattern.unboundedknapsack;

import java.util.Arrays;

/**
 * Maximum number of segments of lengths a, b and c
 * <p>
 * Given a positive integer N, find the maximum number of segments of lengths a, b and c that can be formed from N .
 * <p>
 * Examples :
 * <p>
 * Input : N = 7, a = 5, b, = 2, c = 5
 * Output : 2
 * N can be divided into 2 segments of lengths
 * 2 and 5. For the second example,
 * <p>
 * Input : N = 17, a = 2, b = 1, c = 3
 * Output : 17
 * N can be divided into 17 segments of 1 or 8
 * segments of 2 and 1 segment of 1. But 17 segments
 * of 1 is greater than 9 segments of 2 and 1.
 */
public class MaxRibbonCut {


    public static void main(String... s) {
        int n = 7;
        int arr[] = new int[]{5, 2, 5};

//        int n = 17;
//        int arr[] = new int[]{2, 1, 3};

        int[][] memo = new int[arr.length + 1][n + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        System.out.println(findMaxRibbonCuts(arr, n, 0, memo));
//        System.out.println(findMaxRibbonCutsDFS(arr, n, 0, memo) - 1);
    }

    private static int findMaxRibbonCuts(int[] arr, int n, int index, int[][] memo) {

        if (memo[index][n] != -1) {
            return memo[index][n];
        }

        if (n == 0) {
            return 1;
        }

        if (index == arr.length) {
            return 0;
        }


        int include = 0;
        if (n - arr[index] >= 0) {
            include = findMaxRibbonCuts(arr, n - arr[index], index, memo);
        }
        int exclude = findMaxRibbonCuts(arr, n, index + 1, memo);

        if (include == 0 && exclude == 0) {
            include = -1;
            exclude = -1;
        }

        memo[index][n] = 1 + Math.max(include, exclude);
        return memo[index][n];
    }

    private static int findMaxRibbonCutsDFS(int[] arr, int n, int index, int[][] memo) {

        if (memo[index][n] != -1) {
            return memo[index][n];
        }

        if (n == 0) {
            return 1;
        }

        if (index == arr.length) {
            return 0;
        }


        int include = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (n - arr[i] >= 0) {
                include = findMaxRibbonCutsDFS(arr, n - arr[i], i, memo);
            }
            if (include > max) {
                max = include;
            }
        }

        //take care of cases where each children is returning 0, you dont want to add 1 + in this case
        //since its not the optimal solution we are looking for.
        if (max == 0) {
            max = -1;
        }
        memo[index][n] = 1 + max;
        return memo[index][n];
    }
}
