package com.preparation.ds.array;

/**
 * Difficulty Level Hard: Expected O(n) and O(1)
 * https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
 *
 * 1. Using sorting
 * 2. Using Hashing
 *
 * 3. O(n) time and o(1) space
 * A O(n) time and O(1) extra space solution:
 * The idea is similar to this post. We use array elements as index.
 * To mark presence of an element x, we change the value at the index x to negative.
 * But this approach doesn’t work if there are non-positive (-ve and 0) numbers.
 * So we segregate positive from negative numbers as first step and then apply the approach.
 *
 * Following is the two step algorithm.
 * 1) Segregate positive numbers from others i.e., move all non-positive numbers to left side.
 * In the following code, segregate() function does this part.
 * 2) Now we can ignore non-positive elements and consider only the part of array which contains all positive elements.
 * We traverse the array containing all positive numbers and to mark presence of an element x,
 * we change the sign of value at index x to negative. We traverse the array again and print the first
 * index which has positive value. In the following code, findMissingPositive() function does this part.
 * Note that in findMissingPositive, we have subtracted 1 from the values as indexes start from 0 in C.
 */
public class FindSmallestMissingInteger {
}
