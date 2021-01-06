package com.preparation.algorithm.traversing;

import java.util.Arrays;

/**
 * Maximum number of partitions that can be sorted individually to make sorted
 * Given an array arr[] of size n such that elements of arr[] in range [0, 1, ..n-1] where every number is present at most once. Our task is to divide the array into maximum number of partitions that can be sorted individually, then concatenated to make the whole array sorted.
 * <p>
 * Examples :
 * <p>
 * Input : arr[] = [2, 1, 0, 3]
 * Output : 2
 * If divide arr[] into two partitions
 * {2, 1, 0} and {3}, sort then and concatenate
 * then, we get the whole array sorted.
 * <p>
 * Input : arr[] = [2, 1, 0, 3, 4, 5]
 * Output : 4
 * The maximum number of partitions are four, we
 * get these partitions as {2, 1, 0}, {3}, {4}
 * and {5}
 */
public class ArraySortedPartition {

    public static int findPartition(int[] arr) {
        int max = arr[0];
        int partitions = 0;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(arr[i],max);
            if(max==i)
                partitions++;
        }

        return partitions;

    }

    private static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(x -> System.out.println(x));
    }

    public static void main(String... s) {
//        int arr[] = new int[]{2, 1, 0, 3, 4, 5};
        int arr[] = new int[]{2, 1, 0, 3};
        System.out.println(findPartition(arr));

    }

}
