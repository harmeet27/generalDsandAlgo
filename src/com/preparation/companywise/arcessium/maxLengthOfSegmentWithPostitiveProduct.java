package com.preparation.companywise.arcessium;

/**
 * You are given sequence of n integers and you have to find the maimum length of a segment which gives possitive product.
 * <p>
 * Complete the maxLength function
 * <p>
 * It musst return an integer denoting the maximum length of a segment which gives positive product.
 * <p>
 * CONSTRAINTS:
 * 1 < n<=1000
 * <p>
 * SAMple input:
 * 4
 * 1
 * -2
 * -3
 * 4
 * <p>
 * Sampple output:
 * 4
 * <p>
 * INPUT 2:
 * 2
 * -3
 * 5
 * <p>
 * OUPUT: 1
 * <p>
 * <p>
 * <p>
 * APPROACH: find negativeCount , crate a list and insert negative numbers with their postive count till this point
 * <p>
 * 3. Obtain the prefetch sum
 * 4. Since in case of odd negative numbers, we just cant take one of it, which means the positve numbers which we can take
 * either lie on left prefetch sum of this or right of it.
 * <p>
 * SSo obtain the max(left,right) for each arr[i].
 * <p>
 * and keep a count of max. Thats your answer.
 */
public class maxLengthOfSegmentWithPostitiveProduct {
}
