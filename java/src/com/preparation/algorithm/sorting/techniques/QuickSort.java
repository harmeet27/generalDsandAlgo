package com.preparation.algorithm.sorting.techniques;

import java.util.Arrays;

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

    // idea is to move all smaller elements from pivot to left while traversing l to r.
    public void quick(int[] nums, int l, int r) {// quick select: kth smallest
        if (l > r) return;

        int pivot = nums[r];// Take A[end] as the pivot,
        int left = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
                swap(left++, i, nums);
        }
        swap(left, r, nums);// Finally, swap A[pivot] with A[left] : as left is pointing to correct pivot element position

        quick(nums, left + 1, r);
        quick(nums, l, left - 1);
    }

    public static void main(String... s) {
        QuickSort adv = new QuickSort();
        int arr[] = {5, 1, 3, 6, 2, 4};
        adv.quick(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(e -> System.out.print(e+","));
    }

    private void swap(int l, int r, int arr[]) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


}
