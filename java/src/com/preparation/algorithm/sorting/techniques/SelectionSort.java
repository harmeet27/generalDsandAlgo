package com.preparation.algorithm.sorting.techniques;

import java.util.Arrays;

/**
 * find the next min starting from current and swap it with current.
 */
public class SelectionSort {

    public void performSelectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = findMin(a, i);
            swap(a, i, min);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int findMin(int[] arr, int start) {
        int minIndex = start;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }


    public static void main(String... s) {
        SelectionSort selectionSort = new SelectionSort();
        int a[] = {3, 1, 4, 7, 8};
        selectionSort.performSelectionSort(a);
        Arrays.stream(a).forEach(element -> System.out.print("" + element + ","));
    }
}
