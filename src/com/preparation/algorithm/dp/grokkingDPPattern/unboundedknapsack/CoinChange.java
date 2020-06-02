package com.preparation.algorithm.dp.grokkingDPPattern.unboundedknapsack;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * <p>
 * For example, for N = 4 and S = {1,2,3},
 * there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4.
 * <p>
 * For N = 10 and S = {2, 5, 3, 6},
 * there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 * So the output should be 5.
 */
public class CoinChange {

    public static void main(String... s) {
        int coins[] = new int[]{1, 2, 3};
        int k = 4;

        int[][] memo = new int[coins.length + 1][k + 1];
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));
        System.out.println(coinChangeWays(coins, k, 0, 0, memo));
    }

    private static int coinChangeWays(int[] coins, int k, int index, int sum, int[][] memo) {

        if (memo[index][sum] != -1) {
            return memo[index][sum];
        }

        if (sum == k) {
            return 1;
        }

        if (index == coins.length) {
            return 0;
        }

        int include = 0;
        if (sum + coins[index] <= k) {
            include = coinChangeWays(coins, k, index, sum + coins[index], memo);
        }
        int exclude = coinChangeWays(coins, k, index + 1, sum, memo);

        memo[index][sum] = include + exclude;

        return memo[index][sum];
    }
}
