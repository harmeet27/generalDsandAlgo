package com.preparation.algorithm.dp.tabulation;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int lengthOfLISMemo(int[] nums) {
        int[][] memo = new int[nums.length + 1][nums.length + 1];
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));
        return lisMemo(nums, 0, -1, memo);
    }


    public static int lisRecursion(int[] nums, int i, int prevElement) {
        if (i == nums.length || nums == null) {
            return 0;
        }
        int include = 0;
        if (nums[i] > prevElement) {
            include = 1 + lisRecursion(nums, i + 1, nums[i]);
        }
        int exclude = lisRecursion(nums, i + 1, prevElement);
        return Math.max(include, exclude);
    }

    private static int lisMemo(int[] nums, int i, int prevIndex, int[][] memo) {
        if (i == nums.length || nums == null) {
            return 0;
        }

        if (prevIndex!=-1 && memo[i][prevIndex+1] != -1) {
            return memo[i][prevIndex+1];
        }
        int include = 0;
        if (prevIndex==-1 || nums[i] > nums[prevIndex]) {
            include = 1 + lisMemo(nums, i + 1, i, memo);
        }

        int exclude = lisMemo(nums, i + 1, prevIndex, memo);
        memo[i][prevIndex+1] = Math.max(include, exclude);
        return memo[i][prevIndex+1];
    }

    public static void main(String... s){
        int[] data = new int[]{3,1,2};
        System.out.println(lisRecursion(data,0,Integer.MIN_VALUE));
        System.out.println(lengthOfLISMemo(data));
    }
}
