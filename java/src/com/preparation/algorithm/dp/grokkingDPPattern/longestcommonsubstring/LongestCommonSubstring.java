package com.preparation.algorithm.dp.grokkingDPPattern.longestcommonsubstring;

import java.util.Arrays;


/**
 * For dp based approach:
 * The time complexity is o(n^2) and auxillary space also the same.
 * <p>
 * The space complexity can be further improved to 0(n) as calculating LCS of a row of the LCS table requires only the solutions to the current row and the prev row.
 * that is by manipulatin the single 1d array it can be done too.
 */


public class LongestCommonSubstring {

    public static int findLength(int[] A, int[] B, int algoOption) {


        switch (algoOption) {
            case 1:
                return lcsRecursionBacktrack(A, B, A.length - 1, B.length - 1, 0);

            case 2:
                int[][][] memo = new int[A.length + 1][B.length + 1][Math.max(A.length, B.length) + 1];
                Arrays.stream(memo).forEach(x -> Arrays.stream(x).forEach(arr -> Arrays.fill(arr, -1)));
                return lcs(A, B, A.length - 1, B.length - 1, 0, memo);
            case 3:
                int[][] memo2d = new int[A.length + 1][B.length + 1];
                Arrays.stream(memo2d).forEach(arr -> Arrays.fill(arr, -1));
                return lcsMemoOptimizeSpace(A, B, A.length - 1, B.length - 1, 0, memo2d);
            case 4:
                int[][] dp = new int[A.length + 1][B.length + 1];//for simplicity we ignore oth index in dp table and keep it with 0.
                return lcsDp(A, B, dp);
//            case 5:
//                int[] dpSingle = new int[A.length + 1];//for simplicity we ignore oth index in dp table and keep it with 0.
//                return lcsDpSingleArrat(A, B, dpSingle);
            default:
                return 0;
        }
    }

    private static int lcsRecursionBacktrack(int[] a, int[] b, int i, int j, int len) {
        if (i < 0 || j < 0 || a == null || b == null) {
            return len;
        }

        int common = 0;
        if (a[i] == b[j]) {
            common = lcsRecursionBacktrack(a, b, i - 1, j - 1, len + 1);
        }

        int notCommon = Math.max(lcsRecursionBacktrack(a, b, i - 1, j, 0), lcsRecursionBacktrack(a, b, i, j - 1, 0));
        return Math.max(len, Math.max(common, notCommon));

    }


    private static int lcs(int[] a, int[] b, int i, int j, int len, int[][][] memo) {
        if (i < 0 || j < 0 || a == null || b == null) {
            return len;
        }

        if (memo[i][j][len] != -1) {
            return memo[i][j][len];
        }

        int common = 0;
        int notCommon = 0;
        if (a[i] == b[j]) {
            common = lcs(a, b, i - 1, j - 1, len + 1, memo);
        }

        notCommon = Math.max(lcs(a, b, i - 1, j, 0, memo), lcs(a, b, i, j - 1, 0, memo));
        common = Math.max(common, notCommon);
        memo[i][j][len] = Math.max(common, len);
        return memo[i][j][len];
    }


    private static int lcsMemoOptimizeSpace(int[] a, int[] b, int i, int j, int len, int[][] memo) {
        if (i < 0 || j < 0 || a == null || b == null) {
            return len;
        }

        if (memo[i][j] != -1) {
            if (len > memo[i][j]) {
                memo[i][j] = len;
            }
            return memo[i][j];
        }

        int common = 0;
        if (a[i] == b[j]) {
            common = lcsMemoOptimizeSpace(a, b, i - 1, j - 1, len + 1, memo);
        }

        int notCommon = Math.max(lcsMemoOptimizeSpace(a, b, i - 1, j, 0, memo), lcsMemoOptimizeSpace(a, b, i, j - 1, 0, memo));
        memo[i][j] = Math.max(len, Math.max(common, notCommon));
        return memo[i][j];
    }


    private static int lcsDp(int[] a, int[] b, int dp[][]) {

        int maxCount = 0;

        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= b.length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxCount = Math.max(dp[i][j], maxCount);
                } else {
                    dp[i][j] = 0; //resetting to 0 if the current value is not matched
                }
            }
        }
        return maxCount;
    }

//    private static int lcsDpSingleArrat(int[] a, int[] b, int dp[]) {
//
//        int maxCount = 0;
//        dp[0] = 0;
//        for (int i = 1; i <= a.length; i++) {
//            for (int j = 1; j <= b.length; j++) {
//                if (a[i - 1] == b[j - 1]) {
//                    dp[i] = 1 + dp[i - 1];
//                    maxCount = Math.max(dp[i], maxCount);
//                } else {
//                    dp[i] = 0; //resetting to 0 if the current value is not matched
//                }
//            }
//        }
//        return maxCount;
//    }


    public static void main(String... s) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}, 1));
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}, 2));
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}, 3));
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}, 4));
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}, 5));
    }
}
