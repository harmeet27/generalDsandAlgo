package com.preparation.leetcode.thirtyday.challenge.daythree;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 * <p>
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProdutOfArray {
    public int[] productExceptSelf(int[] nums) {
        return calc(nums);
    }

    private int[] calc(int[] arr) {
        int temp = 1;
        int[] prod = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            prod[i] = temp;
            temp = temp * arr[i];
        }

        temp = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            prod[i] = temp * prod[i];
            temp = temp * arr[i];
        }

        return prod;

    }
}
