package com.preparation.leetcode.thirtyday.challenge.daytwo;

import java.util.HashMap;

/**
 * Same HashMap technique
 *
 * Contiguous Array
 * Solution
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 *
 */
public class SubarrayEqualNumberOf01 {

    static int findEqual(int arr[]) {
        int maxLength = 0;
        HashMap<Integer, Integer> records = new HashMap<>();
        int currSum = 0;
        //this is imp, for lets say only 1 possible case then the whole length is to be considered.
        records.put(0,-1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                currSum += -1;
            } else {
                currSum += 1;
            }

            if (records.containsKey(currSum)) {
                int currLength = i - records.get(currSum);
                maxLength = maxLength > currLength ? maxLength : currLength;
            }

            records.put(currSum, records.getOrDefault(currSum, i));

        }


        return maxLength;
    }

    public static void main(String... s) {
        int[] arr = new int[]{0, 1};
        System.out.println(findEqual(arr));
    }
}
