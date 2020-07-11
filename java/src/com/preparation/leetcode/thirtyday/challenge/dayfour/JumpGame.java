package com.preparation.leetcode.thirtyday.challenge.dayfour;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i][j] <= 10^5
 * <p>
 * <p>
 * Approach:
 * 1. DFS based approach is 0(n*k)
 * 2. Greedy algorithm can be applied: o(n)
 * <p>
 * reach =0;
 * For each
 * reach = max(reach, (i+nums[i]));
 * make sure reach at anytime is >= index. else we cant reach this index and return false from here.
 */
public class JumpGame {

    public static boolean canJumpDfs(int[] nums) {
        HashSet<Integer> visitedIndex = new HashSet<>();
        boolean canVisit = false;
        Stack<Integer> stack = new Stack();
        stack.add(0);
        while (!stack.isEmpty()) {
            int index = stack.pop();

            if (visitedIndex.contains(index)) {
                continue;
            }

            visitedIndex.add(index);

            if (index == nums.length - 1) {
                canVisit = true;
                break;
            }
            stack.addAll(findPossible(nums, index));

        }

        return canVisit;

    }

    private static List<Integer> findPossible(int[] nums, int i) {
        List<Integer> possiblePath = new LinkedList<>();
        int val = nums[i];
        int count = 1;
        while (count <= val) {
            int pathIndex = i + count;
            if (pathIndex < nums.length) {
                possiblePath.add(pathIndex);
            }
            count++;
        }
        return possiblePath;
    }

    public static boolean greedyCanJump(int[] nums) {
        boolean isPossible = false;
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reach >= i) {
                if (i == nums.length - 1) {
                    isPossible = true;
                }
                reach = Math.max(reach, (i + nums[i]));
            } else {
                break;
            }
        }

        return isPossible;
    }

    public static void main(String... s) {
//        int[] nums = new int[]{2, 3, 1, 1, 4};
        int[] nums = new int[]{3, 2, 1, 0, 4};

        System.out.println(canJumpDfs(nums));
        System.out.println(greedyCanJump(nums));
    }
}
