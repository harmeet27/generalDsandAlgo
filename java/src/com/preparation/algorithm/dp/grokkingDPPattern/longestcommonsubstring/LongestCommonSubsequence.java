package com.preparation.algorithm.dp.grokkingDPPattern.longestcommonsubstring;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Difference between LCS and longest common substring(always consecutive, or contionous)
 * <p>
 * Number of combinations with 2 elements are nC2 and so forth and so on. We know that nC0 + nC1 + nC2 + … nCn = 2n.
 * So a string of length n has 2n-1 different possible subsequences since we do not consider the subsequence with length 0.
 * This implies that the time complexity of the brute force approach will be O(n * 2n). Note that it takes O(n) time to check if a subsequence
 * is common to both the strings. This time complexity can be improved using dynamic programming.
 * <p>
 * It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files),
 * and has applications in bioinformatics.
 */
public class LongestCommonSubsequence {


    public static long dpLcs(String m1, String m2, long[][] dp) {

        for (int i = 0; i <= m1.length(); i++) {
            for (int j = 0; j <= m2.length(); j++) {

                //populatr base case:
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (m1.charAt(i-1) == m2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                } else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[m1.length()][m2.length()];
    }

    public static long recursiveFindLCS(String m1, String m2, int first, int second) {
        //base case
        if (m1 == null || m2 == null) {
            return 0;
        }

        if (first < 0 || second < 0) {
            return 0;
        }

        //regular cases
        if (m1.charAt(first) == m2.charAt(second)) {
            return 1 + recursiveFindLCS(m1, m2, first - 1, second - 1);
        }
        return Math.max(recursiveFindLCS(m1, m2, first - 1, second), recursiveFindLCS(m1, m2, first, second - 1));
    }

    public static void main(String... s) {
        String str1 = "abcdghllktofsadd";
        String str2 = "abedfghfd";

        long memo[][] = new long[str1.length()][str2.length()];
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));

        long recTime = System.currentTimeMillis();
        System.out.println(recursiveFindLCS(str1, str2, str1.length() - 1, str2.length() - 1));
        System.out.println(System.currentTimeMillis() - recTime + " time taken by recursive code");
        recTime = System.currentTimeMillis();
        System.out.println(memoFindLCS(str1, str2, str1.length() - 1, str2.length() - 1, memo));
        System.out.println(System.currentTimeMillis() - recTime + " time taken by memo dp code");

        //to print common index
        System.out.println(findLCSValue(str1, str2, str1.length() - 1, str2.length() - 1, new List[str1.length()][str2.length()], new LinkedList()).toString());
        System.out.println(dpLcs(str1, str2, new long[str1.length()+1][str2.length()+1]));
    }

    private static long memoFindLCS(String m1, String m2, int index1, int index2, long[][] dp) {
        //base case
        if (m1 == null || m2 == null) {
            return 0;
        }

        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        //regular cases
        if (m1.charAt(index1) == m2.charAt(index2)) {
            dp[index1][index2] = 1 + memoFindLCS(m1, m2, index1 - 1, index2 - 1, dp);
        } else {
            dp[index1][index2] = Math.max(memoFindLCS(m1, m2, index1 - 1, index2, dp), memoFindLCS(m1, m2, index1, index2 - 1, dp));
        }
        return dp[index1][index2];
    }

    public static List<Integer> findLCSValue(String str1, String str2, int i, int j, List<Integer>[][] memo, List<Integer> solution) {
        if (i < 0 || j < 0 || str1 == null || str2 == null) {
            return new LinkedList<>();
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        List<Integer> currentValues = new LinkedList<>();
        currentValues.addAll(solution);

        if (str1.charAt(i) == str2.charAt(j)) {
            currentValues.addAll(findLCSValue(str1, str2, i - 1, j - 1, memo, solution));
            currentValues.add(i);
        } else {
            List<Integer> lIncluded = findLCSValue(str1, str2, i - 1, j, memo, solution);
            List<Integer> rIncluded = findLCSValue(str1, str2, i, j - 1, memo, solution);
            currentValues.addAll(lIncluded.size() > rIncluded.size() ? lIncluded : rIncluded);
        }
        memo[i][j] = currentValues;
        return memo[i][j];
    }


}
