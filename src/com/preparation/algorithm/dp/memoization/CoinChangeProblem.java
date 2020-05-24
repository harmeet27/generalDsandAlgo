package com.preparation.algorithm.dp.memoization;

import java.util.HashMap;

public class CoinChangeProblem {

    static HashMap<String, Integer> records = new HashMap();

    static int coinChange(int arr[], int target, int i, int sum) {

        if (i >= arr.length) {
            return 0;
        }

        String key = i + "-" + sum;
        if (records.containsKey(key)) {
            return records.get(key);
        }

        if (sum > target) {
            records.put(key, 0);
            return 0;
        }


        if (sum == target) {
            records.put(key, 1);
            return 1;
        }

        int total = coinChange(arr, target, i, sum + arr[i]) + coinChange(arr, target, i + 1, sum);
        records.put(key, total);

        return total;

    }

    public static void main(String... s) {
//        int arr[] = new int[]{1, 2, 5};
//        int amount = 5;
//        System.out.println(coinChange(arr, amount, 0, 0));

        int arr[] = new int[]{2};
        int amount = 3;
        System.out.println(coinChange(arr, amount, 0, 0));

    }
}
