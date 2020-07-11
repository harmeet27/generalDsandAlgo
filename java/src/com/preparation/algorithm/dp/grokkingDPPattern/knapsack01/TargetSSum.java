package com.preparation.algorithm.dp.grokkingDPPattern.knapsack01;

import java.util.HashMap;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 * For each integer, you should choose one from + and - as its new symbol.
 * <p>
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * <p>
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 */
public class TargetSSum {

    public static void main(String... s) {
        int nums[] = new int[]{1, 1, 1, 1, 1};
        int k = 3;
        System.out.println(findTargetSum(nums, k)
        );
    }

    static long count;

    public static long findTargetSum(int[] nums, int k) {
        HashMap<String, Long> memo = new HashMap();

        return findTargetSum(nums, k, 0, 0, memo);

    }

    private static long findTargetSum(int[] nums, int k, int index, int sum, HashMap<String, Long> memo) {

        String key = index + "-" + sum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (index == nums.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }


        long included = findTargetSum(nums, k, index + 1, sum + nums[index], memo);
        long excluded = findTargetSum(nums, k, index + 1, sum - nums[index], memo);

        memo.put(key, included + excluded);

        return included + excluded;

    }

}
