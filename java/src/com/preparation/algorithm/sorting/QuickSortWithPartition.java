package com.preparation.algorithm.sorting;
/**
 * 1. Find pivotElement --> mid
 * 2. find from left, larger than pivot, and from right smaller.
 * 3. of l<r swap l,r --> keep pivot element as it is even if it has been swapped.
 * 4. if not you are out of loop and divide it into 2 arrays. At this time :
 *      When the right bound crosses the left bound, all elements to the left of the left bound are
 *      less than the pivot and all elements to the right are greater than or equal to the pivot.
 *
 *      which is why at this point we partition from index = l-1. Here pivot gets fixed
 */

import java.util.Arrays;

public class QuickSortWithPartition {

    void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(x -> System.out.print(x + ", "));
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r)
            return;

        int pivotPosition = partition(nums, l, r);

        //since l and r can have max diff of 1
        quickSort(nums, l, pivotPosition);
        quickSort(nums, pivotPosition + 1, r);
    }

    private int partition(int arr[], int l, int r) {
        int start = l;
        int end = r;
        int pivotIndex = start + (end - start) / 2;
        int pivot = arr[pivotIndex];
        while (l <= r) {
            while (arr[l] < pivot) {
                l++;
            }

            while (arr[r] > pivot) {
                r--;
            }

            if (l <= r) {
                swap(l, r, arr);
                l++;
                r--;
            }
        }

        //i.e. l>r whenever l crosses r, then the left elements of l will  be smaller than pivot
        //and right elements of l will be greater than pivot.
        return l - 1;
    }

    private void swap(int l, int r, int arr[]) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String... s) {
        QuickSortWithPartition quickSort = new QuickSortWithPartition();
//        int arr[] = new int[]{8, 4, 3, 2, 1, 9, 11, 2, 5};
        int arr[] = new int[]{5, 1, 1, 2, 0, 0};
        quickSort.sort(arr);
    }
}
