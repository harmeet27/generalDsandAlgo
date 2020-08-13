package com.preparation.algorithm.dp.grokkingDPPattern.palindromicsubsequence;

import java.util.Arrays;

/**
 * Algo:
 * Based on that if we reverse the original string and perform a Longest common subsequence, it will result in the
 * the longest Palindromic subsequnce of the String.
 */
public class LongestPalindromicSubsequnce {

    public static int longestPalindromeSubseq(String s) {
        int[][] memo = new int[s.length() + 1][s.length() + 1];
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));
        StringBuilder sb = new StringBuilder(s);
        return longestPalindromic(s, sb.reverse().toString(), s.length() - 1, s.length() - 1, memo);
    }

    private static int longestPalindromic(String original, String reverse, int oIndex, int rIndex, int[][] memo) {

        if (oIndex < 0 || rIndex < 0) {
            return 0;
        }

        if (memo[oIndex][rIndex] != -1) {
            return memo[oIndex][rIndex];
        }


        if (original.charAt(oIndex) == reverse.charAt(rIndex)) {
            memo[oIndex][rIndex] = 1 + longestPalindromic(original, reverse, oIndex - 1, rIndex - 1, memo);
        } else {
            memo[oIndex][rIndex] = Math.max(longestPalindromic(original, reverse, oIndex - 1, rIndex, memo), longestPalindromic(original, reverse, oIndex, rIndex - 1, memo));
        }

        return memo[oIndex][rIndex];


    }


    public static void main(String... s) {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));
    }
}
