package com.preparation.algorithm.backtracking;

/**
 * Problem Statement #
 * Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both the subsets is equal.
 * <p>
 * Example 1: #
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
 * Example 2: #
 * Input: {1, 1, 3, 4, 7}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
 * Example 3: #
 * Input: {2, 3, 4, 6}
 * Output: False
 * Explanation: The given set cannot be partitioned into two subsets with equal sum.
 *
 *
 * APPROACH:
 * Assume if S represents the total sum of all the given numbers, then the two equal subsets must have a sum equal to S/2.
 * This essentially transforms our problem to: "Find a subset of the given numbers that has a total sum of S/2".
 *
 * Basically if one of the set has a sum of S/2 means automatically the remaining set will have s/2 sum so it boils down
 * to find one subset with sum = s/2.
 *
 * So our brute-force algorithm will look like:
 *
 *  for each number 'i'
 *      create a new set which INCLUDES number 'i' if it does not exceed 'S/2', and recursively
 *          process the remaining numbers
 *      create a new set WITHOUT number 'i', and recursively process the remaining items
 *  return true if any of the above sets has a sum equal to 'S/2', otherwise return false
 *
 */
public class EqualSubsetSumPartition {

    public static boolean canPartition(int[] nums) {
        int totalSum=0;

        //calculate sum
        for(int i:nums){
            totalSum+=i;
        }

        //odd sum cant be divided in 2 eaual sets
        if(totalSum%2!=0){
            return false;
        }


        return canPartition(nums,totalSum/2,0,0);
    }


    static boolean canPartition(int[] nums,int k, int index,int sum){
        if(sum==k){
            return true;
        }

        if(index>=nums.length){
            return false;
        }
        boolean included=false;
        if(sum+nums[index] <= k){
            included = canPartition(nums,k, index+1,sum+nums[index]);
        }

        boolean excluded = canPartition(nums,k, index+1, sum);


        return included | excluded;
    }


    public static void main(String... s){
        int nums[] = new int[]{1,5,11,5};

       System.out.println(canPartition(nums)
       );
    }
}
