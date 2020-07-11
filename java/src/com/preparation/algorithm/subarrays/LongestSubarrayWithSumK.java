package com.preparation.algorithm.subarrays;

import java.util.HashMap;

/**
 * based on the same hashmap algorithm of subarray sum equals k.
 * we will keep a track of indexes instead of count in map
 * <p>
 * if key already there , let it be there dont store th latest index while put in map.
 */
public class LongestSubarrayWithSumK {

    public static int subarraySumK(int arr[], int k) {
        //hashmap of sum-k, count
        HashMap<Integer, Integer> records = new HashMap<>();
        //for 0th sum , count is 1
        records.put(0, -1);
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int diff = sum - k;

            if (records.containsKey(diff)) {
                int lastIndex = records.get(diff);
                int maxLengthCurr = i - lastIndex;
                if (maxLengthCurr > max) {
                    max = maxLengthCurr;
                }
            }
            //always store the firsst index where thi value occured not later on
            records.put(sum, records.getOrDefault(sum, i));
        }
        return max;
    }

    public static void main(String[] s) {

        int arr[] = new int[]{1, -1, 1, -1};
//        int arr[] = new int[]{-5, 8, -14, 2, 4, 12};
        int k = 0;

        System.out.println(subarraySumK(arr, k));
    }
}
