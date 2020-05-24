package com.preparation.companywise.arcessium;

import java.util.LinkedList;
import java.util.List;

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

    static int findMaxLengthPositive(int[] arr) {
        List<Integer> negativeValues = new LinkedList<>();

        int countPostiveBeforeNegative = 0;
        for (int i = 0; i < arr.length; i++) {
            countPostiveBeforeNegative++;
            if (arr[i] < 0) {
                negativeValues.add(countPostiveBeforeNegative);
                countPostiveBeforeNegative = 0;
            }
        }

        //all positive or even positive
        if (negativeValues.size() % 2 == 0) {
            return arr.length;
        }

        //last if +ve add the count, else it will not be considered for max length
        if (arr[arr.length - 1] >= 0) {
            negativeValues.add(countPostiveBeforeNegative);
        }


        int[] prefetchSum = findPrefetchSum(negativeValues);
        int max = 0;
        //traverse and findMAx
        for (int i = 0; i < prefetchSum.length; i++) {
            //not considering the current element
            int possibleValue = Math.max((prefetchSum[i] - 1), (prefetchSum[prefetchSum.length - 1] - prefetchSum[i]));
            if (max < possibleValue) {
                max = possibleValue;
            }
        }

        return max;
    }

    private static int[] findPrefetchSum(List<Integer> negativeValues) {
        int[] prefetchSum = new int[negativeValues.size()];
        int sum = 0;
        for (int i = 0; i < negativeValues.size(); i++) {
            sum = sum + negativeValues.get(i);
            prefetchSum[i] = sum;
        }

        return prefetchSum;
    }

    public static void main(String... s) {
//        int[] arr = new int[]{-3, 5};
//        int[] arr = new int[]{5, -3,-2};
//        int[] arr = new int[]{-3, 2, 3, 4, -2, 8, -5};
        int[] arr = new int[]{-3, 2, 3, 4, -2, 8, -5, 8, 7, 6};
//        int[] arr=new int[]{1,-2,3};

        System.out.println(findMaxLengthPositive(arr));
    }
}
