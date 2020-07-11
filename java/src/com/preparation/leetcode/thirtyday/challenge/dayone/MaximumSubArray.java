package com.preparation.leetcode.thirtyday.challenge.dayone;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int max = 0;
        int sum = 0;
        int val = allNegative(nums);
        if (allNegative(nums) != 1) {
            return val;
        }

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum < 0) {
                sum = 0;
            }

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public int allNegative(int[] nums) {
        int count = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                count++;
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
        }

        if (count == nums.length) {
            return max;
        }
        return 1;
    }
}
