package com.preparation.leetcode.thirtyday.challenge.dayone;

import java.util.HashMap;

/**
 * Write an algorithm to determine if a number n is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Return True if n is a happy number, and False if not.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashMap<Integer, Boolean> records = new HashMap();
        while (true) {
            if (n == 1) {
                break;
            }

            if (records.containsKey(n)) {
                return records.get(n);
            } else {
                records.put(n, false);
            }
            n = findSquareSum(n);

        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    private int findSquareSum(int n) {
        int s = 0;
        int r = 0;
        while (n > 0) {
            r = n % 10;
            s = (int) (s + Math.pow(r, 2));
            n = n / 10;
        }
        return s;
    }
}
