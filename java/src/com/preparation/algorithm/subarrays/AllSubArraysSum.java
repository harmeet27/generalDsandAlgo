package com.preparation.algorithm.subarrays;

/**
 * the question is you are given an array, you need to find the sum of all its subarrays in O(n) and in constant space?
 * <p>
 * Sample → 2,3,4
 * <p>
 * So the output will be 30.
 * <p>
 * Simple idea → Traverse through all of the possible subarrays, find their individual sum and then finally add them up to find the total sum. This will take time complexity of O(n^3).
 * <p>
 * O(n^2) for all the possible subarrays and one pass through each subarray to find the sum of it. So the total will be O(n^3). But for larger values of n, this solution is very inefficient.
 * <p>
 * So how to reduce this complexity from O(n^3) to O(n)?
 * <p>
 * <p>
 * <p>
 * Efficient approach → While we are adding the sum of each subarray, we just need to know how much an individual element contributes to the sum of all subarray since the subarray sum only consists of some of the particular element of the subarray. Let's understand this with an example.
 * <p>
 * Like 2,3,4
 * <p>
 * Possible subarrays will be → {2},{2,3}, {2,3,4}, {3}, {3,4}, {4}
 * <p>
 * And the total sum of all the subarray will be just some of these elements like
 * <p>
 * 2+2+3+2+3+4+3+3+4+4=30. →(1)
 * <p>
 * Let's see what is the pattern here → we just need to see how many times a particular element of the array appears in the final solution like in (1).
 * <p>
 * Element index → frequency →element
 * <p>
 * 0→3→2
 * <p>
 * 1→4→3
 * <p>
 * 2→3→ 4
 * <p>
 * 0th Index element comes three times, the 1st index appears four times and 3rd element appears three times.
 * <p>
 * If we try to drive the formula it will be just
 * <p>
 * (n-i)*(i+1) put n=3 and the respective index you'll get the counts of each of the element of the array appearing in the final solution.
 * <p>
 * So all you'll need is to just traverse the array in one pass and put up an equation like
 * <p>
 * sum+=(n-i)*(i+1)*Ai where Ai is the general term for the element of the array. And that's it you just find all the subarray sum in O(n).
 */
public class AllSubArraysSum {

    public static void sum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + ((n - i) * (i + 1) * arr[i]);
        }
        System.out.println(sum);
    }

    public static void main(String... s) {
        int arr[] = new int[]{2, 3, 4};
        AllSubArraysSum.sum(arr);
    }
}
