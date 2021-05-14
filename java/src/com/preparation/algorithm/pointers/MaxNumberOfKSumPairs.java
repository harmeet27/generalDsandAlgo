package com.preparation.algorithm.pointers;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 */
public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> records = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            records.put(nums[i], records.getOrDefault(nums[i], 0) + 1);
        }

        int totalPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            int diff = k - nums[i];

            if (records.containsKey(diff)) {
                if (diff == nums[i]) {
                    int total = records.get(diff);
                    if (total > 1) {
                        totalPairs++;
                        records.put(nums[i], total - 2);
                    }
                } else {
                    if (records.get(nums[i]) > 0 && records.get(diff) > 0) {
                        totalPairs++;
                        records.put(nums[i], records.get(nums[i]) - 1);
                        records.put(diff, records.get(diff) - 1);
                    }
                }


            }

        }

        return totalPairs;
    }
}
