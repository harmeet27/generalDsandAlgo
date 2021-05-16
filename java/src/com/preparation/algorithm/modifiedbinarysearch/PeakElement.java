package com.preparation.algorithm.modifiedbinarysearch;

/**
 * https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
 * <p>
 * Find a peak element
 * Difficulty Level : Medium
 * Last Updated : 14 Dec, 2020
 * Given an array of integers. Find a peak element in it. An array element is a peak if it is NOT smaller than its neighbours.
 * For corner elements, we need to consider only one neighbour.
 * <p>
 * Example:
 * <p>
 * Input: array[]= {5, 10, 20, 15}
 * Output: 20
 * The element 20 has neighbours 10 and 15,
 * both of them are less than 20.
 * <p>
 * Input: array[] = {10, 20, 15, 2, 23, 90, 67}
 * Output: 20 or 90
 * The element 20 has neighbours 10 and 15,
 * both of them are less than 20, similarly 90 has neighbous 23 and 67.
 * <p>
 * Following corner cases give better idea about the problem.
 * <p>
 * If input array is sorted in strictly increasing order, the last element is always a peak element. For example, 50 is peak element in {10, 20, 30, 40, 50}.
 * If the input array is sorted in strictly decreasing order, the first element is always a peak element. 100 is the peak element in {100, 80, 60, 50, 20}.
 * If all elements of input array are same, every element is a peak element.
 * <p>
 * NOTE: It is clear from the above examples that there is always a peak element in the input array.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * nums[i] != nums[i + 1] for all valid i.
 */
public class PeakElement {

    public int findPeakElement(int[] nums) {
        int peakElement = 0;

        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return 0;

        if (nums.length == 2)
            return nums[0] > nums[1] ? 0 : 1;

        int start = 0;
        int end = nums.length;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (isPeak(nums, mid)) {
                return mid;
            } else if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return peakElement;
    }


    private boolean isPeak(int[] nums, int index) {
        if (index == 0)
            return nums[index] > nums[index + 1];
        if (index == nums.length - 1)
            return nums[index] > nums[index - 1];
        return nums[index] > nums[index - 1] && nums[index] > nums[index + 1];
    }
}
