package com.preparation.algorithm.dp.grokkingDPPattern.knapsack01;

import java.util.Arrays;

/**
 * Partition a set into two subsets such that the difference of subset sums is minimum
 * <p>
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
 * <p>
 * If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 * <p>
 * Example:
 * <p>
 * <p>
 * Input:  arr[] = {1, 6, 11, 5}
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * Subset2 = {11}, sum of Subset2 = 11
 * <p>
 * <p>
 * Approach:
 * In basic, if we go thoroughly, we need 2 subsets s1,s2 such that abs(s1-s2)=min; unlike equal partition where s1-s2=0
 * so if can figure out the sum of one subset lets say s1, we can calculate the other subset sum by totalSum-s1;
 * hence abs(s1 - (total-s1)) = min;
 * So question boils down to find the nearest subset sum to k. (which would in this case will give s1 to us and rest we can calculate.)
 * <p>
 * Note: nearest sum to k , cz 2 subset will have min sum if the subset sum is nearest to each other.
 */
public class MinSubSetSumDifference {


    public static void main(String... s) {
        int nums[] = new int[]{1, 6, 11, 5};
        System.out.println(canPartitionWithDiffK(nums));

    }

    public static int canPartitionWithDiffK(int[] nums) {
        int totalSum = Arrays.stream(nums).reduce((sum, element) -> sum = sum + element).getAsInt();

        int halfSum = totalSum / 2;
        int[][] memo = new int[nums.length + 1][halfSum + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        int s1Sum = findPartitionWithNearestKSum(nums, halfSum, 0, 0, memo);
        int s2Sum = totalSum - s1Sum;
        return s2Sum - s1Sum;
    }

    private static int findPartitionWithNearestKSum(int[] nums, int k, int index, int sum, int[][] memo) {

        if (memo[index][sum] != -1) {
            return memo[index][sum];
        }

        if (index == nums.length) {
            return sum;
        }

        int included = sum;
        if (sum + nums[index] <= k) {
            included = findPartitionWithNearestKSum(nums, k, index + 1, sum + nums[index], memo);
        }
        int excluded  = findPartitionWithNearestKSum(nums, k, index + 1, sum, memo);

        memo[index][sum] = Math.max(included, excluded);
        return memo[index][sum];
    }
}
