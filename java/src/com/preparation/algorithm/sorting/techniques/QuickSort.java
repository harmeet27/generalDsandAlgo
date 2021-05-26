package com.preparation.algorithm.sorting.techniques;

public class QuickSort {

    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        if (low >= 0 && high < arr.length && high >= 0 && low < arr.length) {
            int pivotIndex = quick(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int quick(int[] arr, int l, int r) {
        int pivotIndex = r;
        int pivotElement = arr[r];

        while (l <= r) {
            while (l < arr.length && arr[l] < pivotElement) l++;
            while (r >= 0 && arr[r] >= pivotElement) r--;
            if (l <= r) {
                swap(l, r, arr);
            } else {
                swap(l, pivotIndex, arr);
                //found the pivotElement index after which we can divide.
                pivotIndex = l;
                break;
            }
        }
        return pivotIndex;
    }

    private void swap(int l, int r, int arr[]) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String... s) {
        QuickSort adv = new QuickSort();
        int arr[] = {5, 2, 3, 1};
        adv.quickSort(arr, 0, arr.length - 1);
    }


}
