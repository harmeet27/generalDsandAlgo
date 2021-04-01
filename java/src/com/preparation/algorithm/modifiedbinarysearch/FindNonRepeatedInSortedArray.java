package com.preparation.algorithm.modifiedbinarysearch;

import java.util.Arrays;

/**
 * Array of sorted and repeated elements except one element. Find it.
 */
public class FindNonRepeatedInSortedArray {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }

        if (nums.length < 2) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid - 1 < 0 || mid + 1 >= nums.length || (nums[mid + 1] != nums[mid] && nums[mid - 1] != nums[mid])) {
                return nums[mid];
            } else if (nums[mid - 1] != nums[mid]) {
                if (isEven(0, mid - 1)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }


            } else if (nums[mid + 1] != nums[mid]) {
                if (isEven(mid + 1, nums.length - 1)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }


        return -1;

    }


    private boolean isEven(int start, int end) {
        return (end - start + 1) % 2 == 0;
    }

    public static void main(String... s) {
        FindNonRepeatedInSortedArray sortedArray = new FindNonRepeatedInSortedArray();
        sortedArray.singleNumber(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5});
    }
}
