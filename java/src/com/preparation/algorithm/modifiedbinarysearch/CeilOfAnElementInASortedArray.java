package com.preparation.algorithm.modifiedbinarysearch;

/**
 * Given a sorted array and a value x, the floor of x is the largest element in array smaller than or equal to x. Write efficient functions to find floor of x.
 */
public class CeilOfAnElementInASortedArray {

    public static int floorSortedArray(int[] arr, int number) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            if (arr[0] < number) {
                return arr[0];
            }
            return -1;
        }

        int floor = -1;
        int start = arr[0];
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == number) {
                return arr[mid];
            } else if (arr[mid] > number) {
                end = mid - 1;
            } else if (arr[mid] < number) {
                floor = Math.max(floor, arr[mid]);
                start = mid + 1;
            }

        }

        return floor;
    }

    public static void main(String[] s) {
        System.out.println(floorSortedArray(new int[]{1, 2, 8, 10, 10, 12, 19}, 5));
        System.out.println(floorSortedArray(new int[]{1, 2, 8, 10, 10, 12, 19}, 20));
        System.out.println(floorSortedArray(new int[]{1, 2, 8, 10, 10, 12, 19}, 0));
    }
}
