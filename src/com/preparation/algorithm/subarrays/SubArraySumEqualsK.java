package com.preparation.algorithm.subarrays;

import java.util.HashMap;

/**
 * Use HashMap to do it in order of o(n)
 * the idea is that if you have encountered sum-k previously then the current element from the last encountered sum-k
 * is =k and hence you can store it in the hashmap for further evaluation. If index is needed you can
 * compute indexes.
 */
public class SubArraySumEqualsK {


    public static int subarraySumK(int arr[], int k) {
        //hashmap of sum-k, count
        HashMap<Integer, Integer> records = new HashMap<>();
        //for 0th sum , count is 1
        records.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int diff = sum - k;

            if (records.containsKey(diff)) {
                count += records.get(diff);
            }
            records.put(sum, records.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] s) {

        int arr[] = new int[]{1, 2, 3, 4, 5};
        int k = 5;

        System.out.println(subarraySumK(arr, k));
    }
}
