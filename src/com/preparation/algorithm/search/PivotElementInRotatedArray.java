package com.preparation.algorithm.search;

public class PivotElementInRotatedArray {

    public static int findPivotRotatedElement(int[] arr, int low, int high) {

        if (low >= 0 && high <= arr.length - 1 && high > low) {

            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if (arr[mid - 1] > arr[mid]) {
                return arr[mid];
            }

            if (arr[low] <= arr[mid]) {
                return findPivotRotatedElement(arr, mid + 1, high);
            } else if (arr[mid] <= arr[high]) {
                return findPivotRotatedElement(arr, low, mid - 1);
            }
        }
        return -1;

    }

    public static void main(String s[]) {
//        int arr[] = new int[]{7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 16, 16, 17, 1, 2, 3, 4, 5, 6};
        int arr[] = new int[]{ 4, 5, 6, 7,0,1,2};
        int k = 10;
        System.out.println(findPivotRotatedElement(arr, 0, arr.length - 1));
    }
}
