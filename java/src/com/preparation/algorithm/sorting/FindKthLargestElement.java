package com.preparation.algorithm.sorting;

/**
 * Find the median of an unsorted array? k=n/2;
 * <p>
 * Algorithm:
 * 1. Sort the array, and find the arr[k]; --> nlogn
 * if k is much much smaller then we can do it in linear time: o(n), traversing the array and keep an eye on minEncountered.
 * <p>
 * <p>
 * Can we use the similar technique to find the kth max element in linear time for all values of K?
 * <p>
 * 2.  QuickSelect:
 * 1. Find the pivot index using quick select, if the pivot index is break and return
 * 2. Else instead of recursively searching in both the partition, search in the partition where k lies either in the range of l,pivotIdx-1 or pivotIdx+1/
 * <p>
 * In detail:
 * The basic idea is to use Quick Select algorithm to partition the array with pivot:
 * <p>
 * Put numbers < pivot to pivot's left
 * Put numbers > pivot to pivot's right
 * Then
 * <p>
 * if indexOfPivot == k, return A[k]
 * else if indexOfPivot < k, keep checking left part to pivot
 * else if indexOfPivot > k, keep checking right part to pivot
 * Time complexity = O(n)
 * <p>
 * Discard half each time: n+(n/2)+(n/4)..1 = n + (n-1) = O(2n-1) = O(n), because n/2+n/4+n/8+..1=n-1.
 */
public class FindKthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargestQuickSelect(nums, k, 0, nums.length - 1);
    }


    private int findKthLargestQuickSelect(int[] arr, int k, int l, int r) {
        if (l > r) return -1;

        if (l < arr.length && r >= 0) {
            int pivotIdx = quickSort(arr, l, r);

            int kthMaxIndex = arr.length - k;
            if (pivotIdx == kthMaxIndex)
                return arr[pivotIdx];
            else if (kthMaxIndex > pivotIdx)
                return findKthLargestQuickSelect(arr, k, pivotIdx + 1, r);
            else
                return findKthLargestQuickSelect(arr, k, l, pivotIdx - 1);
        }
        return -1;
    }


    private int quickSort(int[] arr, int l, int r) {

        int pivotIdx = r;
        int pivotElement = arr[pivotIdx];

        while (l <= r) {
            while (l < arr.length && arr[l] < pivotElement) l++;
            while (r >= 0 && arr[r] >= pivotElement) r--;

            if (l <= r)
                swap(l, r, arr);
            else {
                swap(l, pivotIdx, arr);
                pivotIdx = l;
                break;
            }
        }

        return pivotIdx;
    }

    public int findKthLargest(int[] nums, int l, int r, int k) {// quick select: kth smallest
        if (l > r) return Integer.MAX_VALUE;

        int pivot = nums[r];// Take A[end] as the pivot,
        int smallerPtr = l; //keeps track of if smaller number is encountered in traversal from l to r, this is the place it is to be stored.
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
                swap(smallerPtr++, i, nums);
        }
        swap(smallerPtr, r, nums);// Finally, swap A[end] with A[smallerPtr] as smallerPtr will now be pointing to pivot index exact position.

        if (smallerPtr == k)// Found kth smallest number
            return nums[smallerPtr];
        else if (smallerPtr < k)// Check right part
            return findKthLargest(nums, smallerPtr + 1, r, k);
        else // Check left part
            return findKthLargest(nums, l, smallerPtr - 1, k);
    }


    private void swap(int l, int r, int arr[]) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
