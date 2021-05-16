package com.preparation.ds.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii/submissions/
 * <p>
 * <p>
 * Idea is go to 2*n indexes, where currentIndex = i%n
 * the next time you visit the indexes, dont push anything to array, i.e. just to check in exisitng array
 * what would be next greater.
 */
public class NextGreaterCircularArray {

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] next = new int[nums.length];
        Arrays.fill(next, -1);

        int i = 1;
        Stack<Integer> stack = new Stack();
        int current = 0;

        stack.push(0);
        while (i < 2 * nums.length) {
            current = nums[i % nums.length];

            while (!stack.isEmpty() && current > nums[stack.peek()]) {
                next[stack.pop()] = current;
            }

            if (i < nums.length) {
                stack.push(i);
            }
            i++;

        }
        return next;

    }
}
