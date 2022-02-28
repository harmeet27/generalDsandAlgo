package com.preparation.algorithm.sorting.techniques;

/**
 * Divide and conquer(merge)
 *
 * In merge sort,
 *      worst case and average case has same complexities O(n log n).
 *      Space complexity : o(N) for merge operation.
 *
 * Efficiency:
 * Merge sort is more efficient and works faster than quick sort in case of larger array size or datasets.
 * whereas
 *
 * Quick sort is more efficient and works faster than merge sort in case of smaller array size or datasets.
 * Sorting method :
 *
 * The quick sort is internal sorting method where the data is sorted in sample.main memory.
 * whereas
 * The merge sort is external sorting method in which the data that is to be sorted cannot be accommodated in the memory and needed auxiliary memory for sorting.
 *
 * Preferred for :
 * Quick sort is preferred for arrays.
 * whereas
 * Merge sort is preferred for linked lists.
 */
public class MergeSort {

    public int[] mergeSort(int[] arr) {
        return divide(arr, 0, arr.length - 1);
    }

    private int[] divide(int[] arr, int l, int r) {
        if (l >= r) {
            return new int[]{arr[l]};
        }

        int mid = l + (r - l) / 2;
        int[] first = divide(arr, l, mid);
        int[] second = divide(arr, mid + 1, r);

        return merge(first, second);

    }


    private int[] merge(int[] arr1, int[] arr2) {
        int fptr = 0;
        int sptr = 0;
        int idx = 0;
        int mergedArr[] = new int[arr1.length + arr2.length];

        while (fptr < arr1.length && sptr < arr2.length) {
            if (arr1[fptr] <= arr2[sptr]) {
                mergedArr[idx] = arr1[fptr];
                fptr++;
            } else {
                mergedArr[idx] = arr2[sptr];
                sptr++;
            }
            idx++;
        }

        //remaining items of either array.
        while (fptr < arr1.length) mergedArr[idx++] = arr1[fptr++];
        while (sptr < arr2.length) mergedArr[idx++] = arr2[sptr++];
        return mergedArr;
    }
}
