package com.preparation.algorithm.dp.grokkingDPPattern.fiboncaccinumbers;

import java.util.Arrays;

/**
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.
 * <p>
 * Example:
 * <p>
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 ->9)
 *
 * Approach 1: Dp with memoization, for each index go and find the min.
 * Time : o(n*m) where m is maxElement in the array.
 *
 * 2.
 * o(n)
 */
public class MinJumpToReachEnd {

    private static int[] memo;
    public int minJumpMemoEnd(int[] nums) {

        if(nums==null || nums.length==0 || nums[0]==0){
            return 0;
        }

        memo=new int[nums.length+1];
        Arrays.fill(memo,-1);
        return minJumpsMemo(nums,0)-1;
    }

    private static int minJumpsMemo(int[] array, int index){
        if(index>=array.length-1)
            return 1;

        if(memo[index]!=-1){
            return memo[index];
        }
        int jumpsSoFar=Integer.MAX_VALUE;
        int boundary=index+array[index];
        for(int i=index+1;i<=boundary;i++){
            int jumps = minJumpsMemo(array,i);
            if(jumps!=Integer.MAX_VALUE)
                jumpsSoFar = Math.min(jumpsSoFar,1+jumps);
        }

        memo[index] = jumpsSoFar;
        return memo[index];
    }

    private static int minJumps(int[] array, int index){
        int maxReach=0;
        int currentReach=0;
        int currentIndex=0;
        int jumps=0;

        while(currentIndex<=maxReach){
            if(currentReach>=array.length-1){
                return jumps;
            }

            maxReach = Math.max(maxReach, currentIndex + array[currentIndex]);
            if(currentReach-currentIndex==0){
                //your reach is over, take the maxReach
                jumps++;
                currentReach=maxReach;
            }
            currentIndex++;

        }

        return 0;

    }

    public static void main(String... s) {
        int arr[] = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        System.out.println(minJumpsToReachEnd(arr));
    }

    private static int minJumpsToReachEnd(int[] arr) {
        return 0;
    }
}
