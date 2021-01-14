package com.preparation.algorithm.modifiedbinarysearch;

/**
 * You are given an integer array nums sorted in ascending order, and an integer target.
 *
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * If target is found in the array return its index, otherwise, return -1.
 */
public class RotatedArray {

    public int searchIterative(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            else if (nums[mid] <= nums[right]) {
                //sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else
                    right = mid - 1;
            } else {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else
                    left = mid + 1;
            }
        }

        return -1;
    }

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private static int search(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        if (l == r) {
            if (nums[l] == target) {
                return l;
            }

        }

        int mid = l + (r - l) / 2;

        if (nums[mid] == target) {
            return mid;
        }


        if (nums[l] > nums[mid]) {

            if (target >= nums[l] || target < nums[mid]) {
                return search(nums, target, l, mid - 1);
            } else {
                return search(nums, target, mid + 1, r);
            }
        } else {
            if (target >= nums[l] && target < nums[mid]) {
                return search(nums, target, l, mid - 1);
            } else {
                return search(nums, target, mid + 1, r);
            }


        }


    }

    public static void main(String... s) {
        search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
    }
}
