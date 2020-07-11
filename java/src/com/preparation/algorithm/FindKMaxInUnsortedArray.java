package com.preparation.algorithm;

import java.util.Arrays;

/**
 * Approach 1: sort and return k-1 index value --> nlog(n)
 * Approach 2: insert all in heap and pop k times --> nlogn + klogn
 * Approach 3: Use quick selection --> apply quick sort, and keep an eye on k-1 index,  till the time your pivot becomes the k-1 to find.
 * worst case : nlogn --> make sure you are traversin in the subpartition which can have k. you can check size to verify that
 * 0(n)
 * <p>
 * a. Select any pivot element.
 * b. Partition the array into 2 sub partitions: one with smaller values than pivot and one with bigger.
 * c. Select the partition that has k-1 in index and ignore the other one.
 * d. Repeat steps a-c recursively on the selected partition.
 * <p>
 * Approach 4: Median algorithm --> o(n)
 * <p>
 * a. Divide the arrat into N/C columns of elements for small odd C(5). odd so as to find median easily
 * b. Find the median of each column by sorting it.
 * c. Take only the medians and repeat steps 1-2 recursively until only one value remains. That value
 * is picked as pivot.
 * <p>
 * d.
 */


public class FindKMaxInUnsortedArray {
    int findMax(int[] arr, int k) {
        findK(arr, k, 0, arr.length - 1);
        printArr(arr);
        return arr[k - 1];
    }

    public void findK(int arr[], int k, int l, int r) {
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

//        if (l < end) {
        if (k >= l && l < end) {
            findK(arr, k, l, end);
        }
        if (k <= r && r > start) {
//        if (r > start) {
            findK(arr, k, start, r);
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
        FindKMaxInUnsortedArray maxInUnsortedArray = new FindKMaxInUnsortedArray();
        int arr[] = new int[]{8, 4, 3, 2, 1, 9, 11, 2, 5};

        System.out.println(maxInUnsortedArray.findMax(arr, 8));
    }
}
