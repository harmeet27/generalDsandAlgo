package com.preparation.algorithm.search;

/**
 * To search element in rotated sorted array
 * <p>
 * 1. Find the pivot element with which it has been rotated
 * 2. call binary search on one of the half according to step 1.
 */
public class FindElementInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            else if (nums[mid] <= nums[right]) {
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

    public static void main(String s[]) {
        int arr[] = new int[]{5, 1, 3};
        int k = 1;
        FindElementInRotatedSortedArray element = new FindElementInRotatedSortedArray();
        System.out.println(element.search(arr, k));
    }
}
