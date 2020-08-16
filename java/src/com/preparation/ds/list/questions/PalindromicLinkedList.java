package com.preparation.ds.list.questions;

/**
 * Find if a list is palindrome or not.
 *
 *
 * Algo1:
 * 1. Use stack and keep psuhing elements to it for one complete traversal.
 * 2. Traverse again and with each value pop the top. Check if both are same. if yes till end of stack the palindrome.
 * 3. Time o(n) , space o(n) for extra stack.
 *
 *
 * Algo2:
 * 1. reverse the remaing half of the list in original list and check with the first half. if both same, then palindrome.
 * 2. If list is needed back, reverse it back again and attach it to original list.
 */
public class PalindromicLinkedList {
}
