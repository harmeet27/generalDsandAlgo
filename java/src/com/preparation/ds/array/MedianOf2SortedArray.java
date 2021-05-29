package com.preparation.ds.array;

public class MedianOf2SortedArray {

    public double medianSortedArraySameSize(int arr1[], int arr2[]) {
        if (arr1 == null || arr1.length == 0) {
            return -1;
        }

        if (arr1.length == 1) {
            return (arr1[0] + arr2[0]) / 2.0;
        }
        return median(arr1, arr2, 0, arr1.length - 1, 0, arr2.length - 1);
    }

    private double median(int[] arr1, int arr2[], int l1, int r1, int l2, int r2) {
        if (r1 - l1 + 1 == 2) {
            return (Math.max(arr1[l1], arr2[l2]) + Math.min(arr1[r1], arr2[r2])) / 2.0;
        }

        double median1 = 0;
        double median2 = 0;
        int mid1 = l1 + (r1 - l1) / 2;
        int mid2 = l2 + (r2 - l2) / 2;
        if (arr1.length % 2 == 0) {
            median1 = (arr1[mid1] + arr1[mid1 - 1]) / 2.0;
            median2 = (arr2[mid2] + arr2[mid2 - 1]) / 2.0;
        } else {
            median1 = arr1[mid1];
            median2 = arr2[mid2];
        }

        if (median1 < median2) {
            return median(arr1, arr2, mid1, r1, l2, mid2);
        } else if (median1 == median2) {
            return median1;
        } else {
            return median(arr1, arr2, l1, mid1, mid2, r2);
        }
    }

    public static void main(String... s) {
        MedianOf2SortedArray medianOf2SortedArray = new MedianOf2SortedArray();
        int[] arr1 = {2, 6, 9, 10, 11};
        int[] arr2 = {1, 5, 7, 12, 15};

        arr1 = new int[]{2, 6, 9};
        arr2 = new int[]{7, 12, 15};
        System.out.println(medianOf2SortedArray.medianSortedArraySameSize(arr1, arr2));
    }
}
