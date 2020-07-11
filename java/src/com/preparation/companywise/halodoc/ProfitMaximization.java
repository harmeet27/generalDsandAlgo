package com.preparation.companywise.halodoc;
/**
 * travel to different vilagges to make some profit. In each village, you gain  some profit.
 * From a village i, you can only move to j iff i<j and the profit gain from village j is a
 * multiple of the profit gain from village i.
 * <p>
 * Find max profit.
 * <p>
 * 6
 * 1 2 3 4 9 8
 * <p>
 * ouput: 15 --> 1 2 4 8
 */

import java.util.HashMap;

public class ProfitMaximization {


    static int max = 0;
    static HashMap<Integer, Integer> records = new HashMap();

    static int solve(int[] p) {
        // Write your code here
        solveSol(p, 0, 0, 1);
        return max;

    }

    static int solveSol(int[] arr, int i, int profit, int lastGain) {

        if (i >= arr.length) {
            return profit;
        }

        if (records.containsKey(i)) {
            return records.get(i);
        }

        int included = 0;
        if (lastGain != 0 && arr[i] % lastGain == 0) {
            included = solveSol(arr, i + 1, profit + arr[i], arr[i]);
        }
        int excluded = solveSol(arr, i + 1, profit, lastGain);
        int sol = Math.max(included, excluded);
        if (max < sol) {
            max = sol;
        }
        records.put(i, sol);
        return sol;

    }


    public static int findDfs(int arr[], int index) {
        if (index >= arr.length) {
            return 0;
        }

        if (records.containsKey(index)) {
            return records.get(index);
        }

        int currMax = 0;
        for (int i = index + 1; i < arr.length; i++) {
            int element = findDfs(arr, i + 1);
            if (element > currMax) {
                currMax = element;
            }
        }

        int value = currMax + arr[index];
        records.put(index, value);
        return value;
    }

    public static void main(String... s) {
        int arr[] = new int[]{1, 2, 3, 4, 9, 8};

        System.out.println(solve(arr));
        System.out.println(findDfs(arr, 0));

    }
}
