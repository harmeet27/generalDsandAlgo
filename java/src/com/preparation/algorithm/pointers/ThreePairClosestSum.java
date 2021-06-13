package com.preparation.algorithm.pointers;

import java.util.Arrays;

public class ThreePairClosestSum {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int nearest = 0;
        int existingDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int k = target - nums[i];
            int l = i + 1;
            int r = nums.length - 1;

            int currSum = 0;
            int threePairSum = 0;
            while (l < r) {

                currSum = nums[l] + nums[r];
                threePairSum = currSum + nums[i];

                if (currSum < k) l++;
                else r--;

                if (Math.abs(target - threePairSum) <= existingDiff) {
                    existingDiff = Math.abs(target - threePairSum);
                    nearest = threePairSum;
                }

            }

        }

        return nearest;
    }
}
