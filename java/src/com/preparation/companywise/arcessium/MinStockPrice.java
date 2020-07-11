package com.preparation.companywise.arcessium;
/**
 * The shares of company X have following behaviour.
 * 1. The price of the share remains the same throughout the day.
 * 2. At each end of the day the share price wither reduces by 1 , or becomes double.
 * <p>
 * One can only buy share when it reaches the target amount/share.
 * Find min number of days after which one can buy share of company X. given the price of the sshare on Day 0 is n/sahre.
 * <p>
 * Constraint: 0<n , target<=10000
 * <p>
 * SAMPLE iNPUT:
 * 10-->n or intial share cost
 * 1--> target
 * <p>
 * SAMPLE OUTPUT: 9
 * <p>
 * SAMPLE INPUT 2:
 * 3
 * 4
 * <p>
 * SAMPLE OUTPUT2:
 * 2
 * <p>
 * <p>
 * <p>
 * ISSUE: with recursive approach you will face stack overflow error, try DFS itrateively.
 */

import java.util.HashSet;
import java.util.Stack;

public class MinStockPrice {

    static int min = Integer.MAX_VALUE;
    static HashSet<Integer> records = new HashSet<>();

    public static void main(String... s) {
        int initialPrice = 10;
        int target = 1;
        findMinStocks(initialPrice, target, initialPrice, 0);
//        findMinStocksIterativeDFS(initialPrice, target);
        System.out.println(min);
    }

    private static void findMinStocks(int initialPrice, int target, int sum, int days) {

        if (sum > 10000) {
            return;
        }
        if (sum < 0) {
            return;
        }

        if (records.contains(sum)) {
            return;
        }

        records.add(sum);
        if (target == sum) {
            if (min > days) {
                min = days;
            }
            return;
        }


        findMinStocks(initialPrice, target, sum - 1, days + 1);
        findMinStocks(initialPrice, target, sum * 2, days + 1);


    }

    private static void findMinStocksIterativeDFS(int initialPrice, int target) {

        Stack<Integer> stack = new Stack<>();
        stack.add(initialPrice);
        HashSet<Integer> visited = new HashSet<>();
        int days = 0;

        while (!stack.isEmpty()) {

            int curr = stack.pop();

            if (curr > 10000) {
                continue;
            }
            if (curr < 0) {
                continue;
            }

            if (visited.contains(curr)) {
                continue;
            }

            visited.add(curr);

            if (target == curr) {
                if (min > days) {
                    min = days;
                }
                return;
            }

            stack.add(curr * 2);
            stack.add(curr - 1);
            days++;
        }
    }

    class Stock {
        int price;
        int sum;
    }
}
