package com.preparation.algorithm.subarrays;

/**
 * Given an array, find the subarray (containing at least k numbers) which has the largest sum.
 *
 * Examples:
 *
 * Input : arr[] = {-4, -2, 1, -3}
 *             k = 2
 * Output : -1
 * The sub array is {-2, 1}
 *
 * Input : arr[] = {1, 1, 1, 1, 1, 1}
 *             k = 2
 * Output : 6
 * The sub array is {1, 1, 1, 1, 1, 1}
 *
 *
 *
 * APPROACH: prefetch ssum
 * This problem is an extension of Largest Sum Subarray Problem.
 *
 * 1) We first compute maximum sum till every index and store it in an array maxSum[].
 * 2) After filling the array, we use the sliding window concept of size k. Keep track of sum of current k elements.
 * To compute sum of current window, remove first element of previous window and add current element.
 * After getting the sum of current window, we add the maxSum of the previous window, if it is greater than current max,
 * then update it else not.
 */
public class SubArrayLengthKMaxSum {

    public static int maxSubArrayWithLengthK(int[] arr, int k) {
        return 0;
    }


    public static void main(String[] s) {

        int arr[] = new int[]{1, 2, 3, 4, 5};
        int k = 5;

        System.out.println(maxSubArrayWithLengthK(arr, k));
    }
}
