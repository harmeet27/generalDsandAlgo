package com.preparation.algorithm.sorting.techniques;

/**
 * Advantage: does not take any extra space, does in place sorting.
 * Depth of recursion : Logarithmic with high probability
 * <p>
 * <p>
 * Insertion sort for small arrays : size ~ 10
 * Quick sort for slightly bigger array
 * Merge sort for Larger array , in million or billions
 */
public class QuickSort {

    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivotIndex = quick(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
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

    // idea is to move all smaller elements from pivot to left while traversing l to r.
    public void quickSortIteratively(int[] nums, int l, int r) {// quick select: kth smallest
        if (l > r) return;

        int pivot = nums[r];// Take A[end] as the pivot,
        int left = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
                swap(left++, i, nums);
        }
        swap(left, r, nums);// Finally, swap A[pivot] with A[left] : as left is pointing to correct pivot element position

        quickSortIteratively(nums, left + 1, r);
        quickSortIteratively(nums, l, left - 1);
    }

    public static void main(String... s) {
        QuickSort adv = new QuickSort();
        int arr[] = {5, 2, 3, 1};
        adv.quickSort(arr, 0, arr.length - 1);
    }

    private void swap(int l, int r, int arr[]) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


}
