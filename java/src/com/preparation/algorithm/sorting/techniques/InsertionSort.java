package com.preparation.algorithm.sorting.techniques;

import java.util.Arrays;

/**
 * insert the new element at start and swap with all the elements on the left till you dont find a smaller element
 * tha current.
 * <p>
 * It assumes that all the element of the left of a value will always be smaller.
 * We need to create a new array to track this.
 * <p>
 * Best case: when array is already sorted: o(n)
 * Worst case: when array is sorted in different order like decreasing.
 * <p>
 * Partially Sorted:
 * Insertion sort runs in linear time for partially sorted arrays. Number of swaps= number of inversions.
 */
public class InsertionSort {

    public void performInsertionSort(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
            i += 1;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String... s) {
        InsertionSort insertionSort = new InsertionSort();
        int a[] = {3, 1, 4, 7, 8, 2};
        insertionSort.performInsertionSort(a);
        Arrays.stream(a).forEach(element -> System.out.print("" + element + ","));
    }
}
