package com.preparation.ds.stack;

import java.util.Stack;

public class NearestGreaterToRight {

    public int[] nearestGreaterToRight(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        if (nums.length == 1)
            nums[0] = -1;

        Stack<Integer> stack = new Stack();
        int i = 0;
        while (i < nums.length && nums.length > 1) {
            if (stack.isEmpty() || nums[stack.peek()] >= nums[i]) {
                stack.push(i);
                i++;
            } else {
                int removedIndex = stack.pop();
                nums[removedIndex] = nums[i];
            }
        }

        nums[nums.length - 1] = -1;

        return nums;
    }
}
