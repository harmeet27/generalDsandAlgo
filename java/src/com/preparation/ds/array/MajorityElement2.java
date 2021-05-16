package com.preparation.ds.array;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/submissions/
 * <p>
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 * <p>
 * Input: nums = [1,2]
 * Output: [1,2]
 * <p>
 * Algorithm : How many values can have more than n/3 frequency --> only 2 max
 * So use boore voting algorithm with twoCounters, one for each
 */
public class MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> solution = new LinkedList();
        if (nums == null || nums.length == 0) return solution;

        int majElement1 = -1;
        int majElement2 = -1;

        int count1 = 0;
        int count2 = 0;

        int index = -1;
        //left to right
        while (++index < nums.length) {

            if (nums[index] == majElement1) count1++;
            else if (nums[index] == majElement2) count2++;
            else if (count1 == 0) {
                count1++;
                majElement1 = nums[index];
            } else if (count2 == 0) {
                count2++;
                majElement2 = nums[index];
            } else {
                count1--;
                count2--;
            }

        }

        //check if the number obtained is actually the maj element or not since boore mayer doessnt gurantee
        count1 = 0;
        count2 = 0;
        for (int element : nums) {
            if (element == majElement1) count1++;
            if (element == majElement2) count2++;
        }


        int totalLength = nums.length / 3;
        if (count1 > totalLength) solution.add(majElement1);
        if (count2 > totalLength && majElement2 != majElement1) solution.add(majElement2);
        return solution;
    }
}
