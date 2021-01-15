package com.preparation.algorithm.modifiedbinarysearch;

/**
 * 1011. Capacity To Ship Packages Within D Days
 * Medium
 *
 * 1712
 *
 * 51
 *
 * Add to List
 *
 * Share
 * A conveyor belt has packages that must be shipped from one port to another within D days.
 *
 * The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 *
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.
 *
 *
 *
 * Example 1:
 *
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation:
 * A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 *
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * Example 2:
 *
 * Input: weights = [3,2,2,4,1,4], D = 3
 * Output: 6
 * Explanation:
 * A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * Example 3:
 *
 * Input: weights = [1,2,3,1,1], D = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 *
 *
 * Constraints:
 *
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 */
public class AllocatePagesToStudents {

    public int shipWithinDays(int[] weights, int D) {
        if(weights==null || weights.length==0){
            return -1;
        }
        int[] preComputedWeights = findMaxAndTotalSum(weights);

        return applyBinarySearch(weights, preComputedWeights, D);

    }

    private int[] findMaxAndTotalSum(int[] weights){
        int totalWeight=0;
        int maxWeight=weights[0];
        for(int i=0;i<weights.length;i++){
            totalWeight+=weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }
        return new int[]{totalWeight, maxWeight};
    }

    private int applyBinarySearch(int[] weights, int[] preWeight, int days){
        int end = preWeight[0];
        int start= preWeight[1];
        int minWeightNeeded = Integer.MAX_VALUE;
        System.out.println("end:"+end+"start"+start);
        while(start<=end){
            int mid=start+(end-start)/2;
            if(possibleDays(weights,mid,days)<=days){
                minWeightNeeded = Math.min(minWeightNeeded, mid);
                end = mid-1;
            }
            else {
                start=mid+1;
            }
        }

        return minWeightNeeded==Integer.MAX_VALUE?-1:minWeightNeeded;

    }

    private int possibleDays(int[] weight, int limit, int days){
        int daysNeeded = 1;
        int currWeight=0;
        for(int i=0;i<weight.length;i++){
            if(currWeight+weight[i]<=limit){
                currWeight+=weight[i];
            }else{
                daysNeeded+=1;
                currWeight=weight[i];
            }
        }
        return daysNeeded;

    }
}
