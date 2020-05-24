package com.preparation.algorithm.backtracking;

public class CoinChangeProblem {

    static int coinChange(int arr[], int target, int i, int sum) {

        if (i >= arr.length) {
            return 0;
        }

        if (sum > target) {
            return 0;
        }

        if (sum == target) {
            return 1;
        }

        return coinChange(arr, target, i, sum + arr[i]) + coinChange(arr, target, i + 1, sum);

    }

    public static void main(String... s) {
//        int arr[] = new int[]{1, 2, 5};
//        int amount = 5;
//        System.out.println(coinChange(arr, amount, 0, 0));

        int arr[] = new int[]{10};
        int amount = 10;
        System.out.println(coinChange(arr, amount, 0, 0));

    }
}
