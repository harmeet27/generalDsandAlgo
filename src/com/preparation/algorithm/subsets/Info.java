package com.preparation.algorithm.subsets;

/**
 * The total number of subsets of a given set of size n is equal to 2^n.
 * <p>
 * For ex:
 * Input: S[] = [1,2,3]
 * Output:
 * [
 * [],
 * [1],
 * [1,2],
 * [1,2,3],
 * [1,3],
 * [2],
 * [2,3],
 * [3]
 * ]
 *
 * Approach to find all subsets:
 * 1. Backtracking Approach - It's a recursive approach where we backtrack each solution after appending the subset to the resultset.
 *      Why Backtracking? Because the backtracking technique is designed to generate every possible solution once.
 *      If we design the algorithm smartly, we can get the backtracking logic to work for us and generate all the possible subsets.
 *
 *      The thought is that if we have N number of elements inside an array, we have exactly two choices for each of them,
 *      either we include that element in our subset or we do not include it. So, the take or not take strategy builds a
 *      pseudo-binary tree of choices returning only the leaves for each combination resulting in the powerset.
 *      (Similar to KnapSack problem of lena na lena or include, exclude.)
 *
 *      Time Complexity :  O( 2^n)
 *
 *      Space Complexity :  O(n) for extra array subset.
 *
 * 2. BitMasking Approach - The binary representation of a number in range 0 to 2^n is used as a mask where the index of set bit
 *      represents the array index to be included in the subset.
 *
 *      So instead of using an array, we can just use a single integer whose individual bits represent the entries of the array. So the ith bit is 1 or 0 as the ith entry of the array is true or false. This is usually called a bitmasking approach which is really handy to solve other types of problems. (Think!)
 *
 *      Note: n-bit integers are just the numbers from 0 (all n bits zero) to 2^n − 1 (all n bits one).
 *
 *      Set S[] = [1,2,3]
 *      Total number of subsets = pow(2, n) = pow(2, 3) = 8
 *
 *      Value of integer           Subsets
 *          000                    -> Empty set
 *          001                    -> 1
 *          010                    -> 2
 *          011                    -> 12
 *          100                    -> 3
 *          101                    -> 13
 *          110                    -> 23
 *          111                    -> 123
 *
 *      Solution steps 
 *      Get the total number of subsets, subset_size = 2^n
 *      Loop for index from 0 to subset_size
 *      Loop for i = 0 to subset_size
 *      If the ith bit in the index is set then, append ith element from the array for this subset.
 *
 *
 *      Time Complexity : O(n*2^n)
 *
 *      Space Complexity : O(n)
 *
 *
 **/
public class Info {
}
