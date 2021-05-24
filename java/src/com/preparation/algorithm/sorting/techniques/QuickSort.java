package com.preparation.algorithm.sorting.techniques;

import java.util.Arrays;

/**
 * 1. Find pivotElement
 * 2. find from left, larger than pivot, and from right smaller.
 * 3. of l<r swap l,r --> keep pivot element as it is even if it has been swapped.
 * 4. if not you are out of loop and divide it into 2 arrays. At this time :
 *      When the right bound crosses the left bound, all elements to the left of the left bound are
 *      less than the pivot and all elements to the right are greater than or equal to the pivot.
 *
 *      which is why at this point we swap l,pivot and divide here. Here pivot gets fixed
 */


public class QuickSort {
    void sort(int[] arr) {
        findK(arr, 0, arr.length - 1);
        printArr(arr);
    }

    public void findK(int arr[], int l, int r) {
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
        //and right elemtns of l will be greater than pivot.
        if (l < end) {
            findK(arr, l, end);
        }
        if (r > start) {
            findK(arr, start, r);
        }

    }

    private void swap(int l, int r, int arr[]) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private void printArr(int[] arr) {
        Arrays.stream(arr).forEach(x -> System.out.println(x));
    }


    public static void main(String... s) {
        QuickSort quickSort = new QuickSort();
        int arr[] = new int[]{8, 4, 3, 2, 1, 9, 11, 2, 5};
        quickSort.sort(arr);
    }
}
