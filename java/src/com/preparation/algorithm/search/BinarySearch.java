package com.preparation.algorithm.search;

import java.util.Arrays;

public class BinarySearch {

    public static int recusriveBinarySearch(int arr[], int start, int end, int k) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (k < arr[mid]) {
            return recusriveBinarySearch(arr, start, mid - 1, k);
        } else if (k > arr[mid]) {
            return recusriveBinarySearch(arr, mid + 1, end, k);
        } else {
            return mid;
        }
    }

    public static int iterativeBinarySearch(int[] arr, int k) {
        int foundIndex = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (k == arr[mid]) {
                foundIndex = mid;
                break;
            } else if (k < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return foundIndex;
    }

    public static void main(String s[]) {
        int arr[] = new int[]{1, 2, 4, 1, 3, 6, 9, 4, 7, 5};
        Arrays.sort(arr);
        int k = 10;
        System.out.println(iterativeBinarySearch(arr, 10));
        System.out.println(recusriveBinarySearch(arr, 0, arr.length - 1, k));


    }
}
