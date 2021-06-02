package com.preparation.algorithm.string;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 * <p>
 * <p>
 * use the concept of KMP for this.
 * Roughly speaking, dp[i+1] stores the maximum number of characters that the string is repeating itself up to position i.
 * Therefore, if a string repeats a length 5 substring 4 times, then the last entry would be of value 15.
 * To check if the string is repeating itself, we just need the last entry to be non-zero and str.size() to divide (str.size()-last entry).
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {

        int i = 1;
        int j = 0;
        int strLen = s.length();
        int lps[] = new int[strLen];
        while (i < strLen) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                //mismatch
                if (j == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        int endLps = lps[strLen - 1];
        if (endLps == 0)
            return false;

        int repeatedLength = strLen - endLps;
        if (strLen % repeatedLength == 0)
            return true;
        return false;
    }
}
