package com.preparation.algorithm.dp;

/**
 * /**
 * * Bottom Up solution.
 * * Uses BFS with memory element.
 * *
 * In the table, all entries are filled one by one.
 * is always iterative in nature.
 *
 * Iterative solutions are always better than recursive in complexity analysis.
 *
 * fill up the table and the bottom right value is the answer for most of the queries like min max
 *
 *
 * ALGORITHM:
 * The basic steps to build bottom-up dynamic programming solutions are as follows:
 *
 * 1- Determine the required set of parameters that uniquely describe the problem (the state).
 * 2- If there are N parameters required to represent the states, prepare an N dimensional DP table, with one entry per state.
 *      This is equivalent to the memo table in top-down DP. However, there are diﬀerences. In bottom-up DP, we only need to
 *      initialize some cells of the DP table with known initial values (the base cases).
 *      Recall that in topdown DP, we initialize the memo table completely with dummy values (usually -1)
 *      to indicate that we have not yet computed the values.
 *
 * 3- Now, with the base-case cells/states in the DP table already ﬁlled, determine the cells/states that can be ﬁlled next
 *      (the transitions). Repeat this process until the DP table is complete. For the bottom-up DP, this part is usually
 *      accomplished through iterations, using loops. lets build a table for 3*3 array with values:
 *
 *
 *
 *      Identify Base cases
 *      Calculating base cases answers
 *      put base cases answers in cache/table
 *      for each parameter1 in some range:
 * 	        for each parameter2 in some range:
 * 		        for each parameter3 in some range:
 * 			    ...
 * 				    calculate answer for this dp state (with the same recurrence)
 * 				    store answer in cache[parameter1][parameter2][parameter3][...];
 *
 * What is left for you to do is to decide the right order to loop over the parameters.
 * Sometimes you will want to go from 0 to N, sometimes you will want to go from N to 0.
 * Usually you can decide this by looking at how your "calculate answer" function works.
 *
 * If answer depends on cache[parameter1 + 1][...], then you want to loop parameter1 from N to 0, because that should guarantee that the cache value you're looking for is already calculated.
 * If answer depends on cache[parameter1 - 1][...], then you want to loop parameter1 from 0 to N, because that should guarantee that the cache value you're looking for is already calculated.
 * If answer depends on cache[parameter1][...], try looking for a hint in the other parameters.
 * Same thing for any other parameter
 * That's the general idea of converting a top-down dp into a bottom-up dp.
 */

public class Tabulation {
}
