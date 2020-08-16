package com.preparation.algorithm.bitwise;

/**
 * LeetCode 260 - Single Number III [medium]
 * <p>
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * Example:
 * <p>
 * Input:  [1, 2, 1, 3, 2, 5]
 * Output: [3, 5]
 * Note:
 * <p>
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * <p>
 * <p>
 * Bitwise XOR SolutionPermalink
 * Let’s say num1 and num2 are the two single numbers. If we do XOR of all elements of the given array, we will be left with XOR of num1 and num2 as all other numbers will cancel each other because all of them appeared twice.
 * <p>
 * Since we now have XOR of num1 and num2, how can we find these two single numbers?
 * <p>
 * As we know that num1 and num2 are two different numbers, therefore, they should have at least one bit different between them!
 * <p>
 * If a bit in n1xn2 is 1, this means that num1 and num2 have different bits in that place. We can take any bit which is 1 in n1xn2 and partition all numbers in the given array into two groups based on that bit.
 * <p>
 * One group will have all those numbers with that bit set to 0 and the other with the bit set to 1. This will ensure that num1 will be in one group and num2 will be in the other.
 * <p>
 * We can take XOR of all numbers in each group separately to get num1 and num2, as all other numbers in each group will cancel each other.
 */
public class Find2NonDuplicateElement {

    public static void find2NonRepeatingNumber(int[] n) {
        int xorSum = 0;
        for (int i = 0; i < n.length; i++) {
            xorSum ^= n[i];
        }

        //find the rightmost set bit
        int rightMostSetBit = xorSum & ~(xorSum - 1);

        //divide the elements into 2 with one as this bit set other as not set, unniwu in both will give 2 unique elements in ecah cell.
        int firstNo = 0;
        int secondNo = 0;
        for (int i = 0; i < n.length; i++) {
            int set = rightMostSetBit & n[i];
            if (set == 1) {
                firstNo = firstNo ^ n[i];
            } else {
                secondNo = secondNo ^ n[i];
            }
        }

        System.out.println("Two unique numbers are " + firstNo + " , " + secondNo);


    }


    public static void main(String... s) {
        int x = 10;
        int n[] = {1,2,3,4,3,2,5,6,6,5};
        find2NonRepeatingNumber(n);
    }
}
