package com.preparation.algorithm.dp.grokkingDPPattern.unboundedknapsack;

import java.util.HashMap;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class MinCoinChanges {

    public static void main(String... s) {
        int coins[] = new int[]{1, 2};
        int k = 3;

        System.out.println(coinChangeMemo(coins, k, 0, 0, new HashMap()));
        System.out.println(coinChangeMemoDFS(coins, k, 0, 0, new HashMap()) - 1);
    }

    private static int coinChangeMemo(int[] coins, int k, int index, int sum, HashMap<String, Integer> memo) {

        String key = index + "-" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (sum == k) {
            return 1;
        }

        if (index == coins.length) {
            return Integer.MAX_VALUE;
        }

        int include = Integer.MAX_VALUE;
        if (sum + coins[index] <= k) {
            include = coinChangeMemo(coins, k, index, sum + coins[index], memo);
        }
        int excluded = coinChangeMemo(coins, k, index + 1, sum, memo);

        if (include == Integer.MAX_VALUE && excluded == Integer.MAX_VALUE) {
            include = -1;
            excluded = -1;
        }

        memo.put(key, (1 + Math.min(include, excluded)));

        return memo.get(key);

    }

    private static int coinChangeMemoDFS(int[] coins, int k, int index, int sum, HashMap<String, Integer> memo) {

        String key = index + "-" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (sum == k) {
            return 1;
        }

        if (index == coins.length) {
            return Integer.MAX_VALUE;
        }

        int minSum = Integer.MAX_VALUE;
        int currSum = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (sum + coins[i] <= k) {
                currSum = coinChangeMemoDFS(coins, k, i, sum + coins[i], memo);
            }
            if (currSum < minSum) {
                minSum = currSum;
            }
        }

        if (minSum == Integer.MAX_VALUE) {
            minSum = -1;
        }

        memo.put(key, 1 + minSum);
        return memo.get(key);
    }

}
