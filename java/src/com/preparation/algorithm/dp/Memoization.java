package com.preparation.algorithm.dp;

/**
 * Memoization refers to the technique of caching and reusing previously computed results.
 *
 *
 * Top Down solution.
 * Uses DFS with memory element.
 * Maintains that bottom elements of your tree are computed first.
 * <p>
 * slow due to recursive calls (and limit of stacks else stackOverflow error)
 * Memoization table is filled on demand, and unline tabulation , all entries may or may not be filled.
 * <p>
 * Ex: All examples in which we are using recursion with loop(DFS) are memoization if dp is introduced.
 *
 *
 *
 * In general, your top-down dp function might look something like this:
 *
 * int dp(parameter1, parameter2, parameter3...) {
 *
 * 	if (base case) {
 * 		return some answer
 *    }
 *    else if (visited[parameter1][parameter2][parameter3][...]) {
 * 		return cache[parameter1][parameter2][parameter3][...];
 *    }
 *    else {
 * 		calculate for this dp state (this is called the recurrence)
 * 		store answer in cache[parameter1][parameter2][parameter3][...];
 * 		return cache[parameter1][parameter2][parameter3][...];
 *    }
 * }
 *
 *
 *
 * Approach 1:
 * 1. For bounded knapsack : Use include/exclude  --> may not be good for cases where we can traverse back to prev values.
 * 2. For unbounded Knapsack : use for with dfs type
 */
public class Memoization {
}
