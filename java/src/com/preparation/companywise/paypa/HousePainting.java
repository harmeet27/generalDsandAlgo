package com.preparation.companywise.paypa;

/**
 * There are N buildings in a locality each building must be painted with a type of paint. InitiaIly, some buildings are painted with some type of paint. The building that is painted cannot be painted again. You are given M types a paints, 1 to M inclusive. The specialty 0f the locality is defined as the number of contiguous buildings that are painted with the same type of paint. For example, if six buildings apartment are painted from left to right are {1, 2, 1, 1, 3, 3}, then the likelihood of the apartment is 4 { {1}, {2}, {1,1}, and {3,3}}. You are given an N x M matrix, where the ith row and jth column denote the painting cost of the ith building with the jth the type of paint.
 * <p>
 * You are required to determine the minimum cost to paint all the buildings such that the specialty of the appartment is exactly K. If it is not possible to paint all building such that the likelihood of the apartment is exactly K, then print -1.
 * <p>
 * Input Format : --> The first line contains T denoting the number of test cases.
 * <p>
 * -> For each test case:
 * <p>
 * –> The next line contains N, M, and K where N is the number of buildings in a locality , M is the number of types of paints, and K is the specialty of the locality respectively.
 * <p>
 * –> The next line contains N space-separated integers where the ith integer is either 0 or the type of paint from which the ith building is already painted. Here, 0 means that the building is not painted.
 * <p>
 * –> The next N lines contain M space-separated integers where the ith row and jth column denote the painting cost (cost i,j of the ith building with the jth type of paint.
 * <p>
 * OUTPUT FORMAT :
 * <p>
 * Print the minimum cost to paint all buildings such that the specialty of the apartment is exactly K. If it is not possible to paint all building such that the likelihood of the apartment is exactly K, then print -1.
 * <p>
 * CONSTRAINTS :
 * <p>
 * 1 ≤ T ≤ 10
 * 1 ≤ K ≤ N ≤ 100
 * 1 ≤ M ≤ 100
 * 1 ≤ cost(i,j) ≤ 10 power 9
 * SAMPLE INPUT :
 * <p>
 * 1
 * <p>
 * 4 2 1
 * <p>
 * 0 0 0 2
 * <p>
 * 100 20
 * <p>
 * 30 59
 * <p>
 * 71 81
 * <p>
 * 9 200
 * <p>
 * SAMPLE OUTPUT :
 * 160
 */
public class HousePainting {
    /**
     * Denote c[i][j]c[i][j] to be the cost of painting the ii-th building as color jj. Also, assume 11-indexing for everything as it makes the math easier.
     *
     * Let dp[i][j][k]dp[i][j][k] be the minimum cost to paint the first ii buildings with jj as the specialty of the first ii buildings, such that the last color used was kk (as in, the color of the ii-th building is kk). If the color of the ii-th building is fixed, then all dp[i][j][k]dp[i][j][k] for that ii are \infty∞ except for when kk is the fixed color. Then when computing dp[i][j][k]dp[i][j][k], there are two possibilities:
     *
     * The color kk is the same as the previous color. Then, when placing this color, the specialty does not change. So the value of this transition is dp[i - 1][j][k]dp[i−1][j][k] + c[i][k]c[i][k]. This takes O(1)O(1) time.
     *
     * The color kk is different from the previous color. In this case, the specialty increases by 11, so the previous specialty must be 11 less than jj. So the value of this transition is the minimum value of dp[i - 1][j - 1][p]dp[i−1][j−1][p] + c[i][k]c[i][k], where pp is any valid color not equal to kk. This takes O(M)O(M) time.
     *
     * The answer is the minimum over dp[N][K][c]dp[N][K][c] over all 1 \leq c \leq M1≤c≤M.
     *
     * Naively, there are O(NMK)O(NMK) states and transitions are O(M)O(M). This will probably not pass if all tests in a file are maxtests. But we can speed the second type of transition up. Let pre[i][j][k]pre[i][j][k] be the prefix minimum of dp[i][j][1 \dots k]dp[i][j][1…k], and suf[i][j][k]suf[i][j][k] be the suffix minimum of dp[i][j][k \dots M]dp[i][j][k…M]. Then the entire second transition can be computed as min(pre[i - 1][j - 1][k - 1], suf[i - 1][j - 1][k + 1]) + c[i][k]min(pre[i−1][j−1][k−1],suf[i−1][j−1][k+1])+c[i][k] (be careful with edge cases). Now this is O(NMK)O(NMK), which should pass easily.
     */
}
