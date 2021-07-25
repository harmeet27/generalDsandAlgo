package com.preparation.algorithm.search;

/**
 * To search element in rotated sorted array
 * <p>
 * 1. Find the pivot element with which it has been rotated
 * 2. call binary search on one of the half according to step 1.
 * <p>
 * <p>
 * Observation : For any mid , there would be worst 2 cases:
 * one side completely sorted and other rotated sorted.
 */
public class FindElementInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
                //if right side array is a sorted array --> then values in range nums[mid] and nums[right] would lie here.
            else if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else
                    right = mid - 1;
            }
            //else left will be a sorted array and then values in range nums[left] and nums[mid] would lie here.
            else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else
                    left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String s[]) {
        int arr[] = new int[]{5, 1, 3};
        int k = 1;
        FindElementInRotatedSortedArray element = new FindElementInRotatedSortedArray();
        System.out.println(element.search(arr, k));
    }
}
