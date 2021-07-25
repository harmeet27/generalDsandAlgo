package com.preparation.algorithm.dp.grokkingDPPattern.fiboncaccinumbers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber
 */
public class HouseTheif {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, 0, memo);
    }


    private int rob(int[] nums, int index, int[] memo) {

        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != -1) return memo[index];

        int include = nums[index] + rob(nums, index + 2, memo);
        int exclude = rob(nums, index + 1, memo);
        memo[index] = Math.max(include, exclude);
        return memo[index];

    }
}
