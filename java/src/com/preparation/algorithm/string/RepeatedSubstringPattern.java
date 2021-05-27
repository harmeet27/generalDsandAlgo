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
}
