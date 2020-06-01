package com.preparation.algorithm.dp.grokkingDPPattern.knapsack01;

import java.util.Arrays;

/**
 * Subset Sum Problem | DP-25
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * Example:
 * <p>
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output: True
 * There is a subset (4, 5) with sum 9.
 * <p>
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 * Output: False
 * There is no subset that add up to 30.
 *
 *
 * Approach :
 * Same logic as used in EqualSubsetSumPartition
 */
public class SubsetSum {

    public static boolean canPartition(int[] nums, int sum) {

        int[][] memo = new int[nums.length + 1][sum + 1];
        for (int[] array : memo) {
            Arrays.fill(array, -1);
        }
        return canPartition(nums, sum, 0, 0, memo);
    }


    static boolean canPartition(int[] nums, int k, int index, int sum, int[][] memo) {

        if (sum == k) {
            return true;
        }

        if (index >= nums.length) {
            return false;
        }

        if (memo[index][sum] != -1) {
            if (memo[index][sum] == 1) {
                return true;
            } else {
                return false;
            }
        }


        boolean included = false;
        if (sum + nums[index] <= k) {
            included = canPartition(nums, k, index + 1, sum + nums[index], memo);
        }

        boolean excluded = canPartition(nums, k, index + 1, sum, memo);

        boolean valid = included | excluded;
        if (valid) {
            memo[index][sum] = 1;
        } else {
            memo[index][sum] = 0;
        }

        return included | excluded;
    }


    public static void main(String... s) {
        int nums[] = new int[]{1, 5, 11, 5};
        int sum = 11;
        System.out.println(canPartition(nums, sum)
        );
    }
}
