package com.preparation.algorithm.dp.grokkingDPPattern.knapsack01;

import java.util.HashMap;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items
 * respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such
 * that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete
 * item or don’t pick it (0-1 property).
 * <p>
 * <p>
 *
 *  Each item can only be selected once, as we don’t have multiple quantities of any item.
 * <p>
 * Ex:
 * value : 60,100,120
 * weight : 10,20,30
 * W=50;
 * <p>
 * ouput: 220
 */
public class KnapSack {


    static int solveKnapSackWithoutDfs01(int weight[], int value[], int k, int sum, int index,
                                         HashMap<String, Integer> memo, int vSum) {
        if (index >= weight.length) {
            return vSum;
        }

        int included = 0;
        if (sum + weight[index] <= k) {
            included = solveKnapSackWithoutDfs01(weight, value, k, sum + weight[index], index + 1, memo, vSum + value[index]);
        }
        int excluded = solveKnapSackWithoutDfs01(weight, value, k, sum, index + 1, memo, vSum);

        return Math.max(included, excluded);
    }

    static int solveKnapSackTopDownMemo(int weight[], int value[], int k, int sum, int index,
                                        HashMap<String, Integer> memo, int vSum) {

        if (index >= weight.length - 1) {
            return vSum;
        }

        if (memo.containsKey(index + "-" + sum)) {
            return memo.get(index + "-" + sum);
        }

        int maxSum = 0;
        int currWeight = 0;
        for (int i = index + 1; i < weight.length; i++) {
            if (sum + weight[i] <= k) {
                currWeight = solveKnapSackTopDownMemo(weight, value, k, sum + weight[i], i, memo, vSum + value[i]);
            } else {
                currWeight = vSum;
            }
            if (currWeight > maxSum) {
                maxSum = currWeight;
            }
        }

        memo.put(index + "-" + sum, maxSum);
        return maxSum;
    }


    public static void main(String... s) {
//        int weight[] = new int[]{10, 20, 30};
//        int value[] = new int[]{60, 100, 120};
//        int k = 50;
        int weight[] = new int[]{10, 20, 30, 40, 50, 15};
        int value[] = new int[]{60, 100, 120, 200, 100, 50};
        int k = 90;

        solveKnapSackTopDownMemo(weight, value, k, 0, -1, new HashMap(), 0);
        System.out.println(solveKnapSackTopDownMemo(weight, value, k, 0, -1, new HashMap(), 0));
        System.out.println(solveKnapSackWithoutDfs01(weight, value, k, 0, 0, new HashMap(), 0));
    }

}
