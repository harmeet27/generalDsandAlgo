package com.preparation.algorithm.dp.grokkingDPPattern.fiboncaccinumbers;

/**
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.
 * <p>
 * Example:
 * <p>
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 ->9)
 */
public class MinJumpToReachEnd {


    public static void main(String... s) {
        int arr[] = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        System.out.println(minJumpsToReachEnd(arr));
    }

    private static int minJumpsToReachEnd(int[] arr) {
        return 0;
    }
}