package com.preparation.algorithm.modifiedbinarysearch;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/find-k-closest-elements
public class KClosestToXSortedArray {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int xIdx = bsNearestIndex(arr, x);
        int start = xIdx - k;
        int end = xIdx + k;

        return getNearestKInRange(arr, start, end, x, k);
    }

    private List<Integer> getNearestKInRange(int arr[], int start, int end, int x, int k) {

        while (start < 0) {
            start++;
        }
        while (end > arr.length - 1) {
            end--;
        }

        while (end - start + 1 > k) {
            if (x - arr[start] > arr[end] - x) {
                start++;
            } else {
                end--;
            }
        }

        List<Integer> sol = new LinkedList();
        for (int i = start; i <= end; i++) {
            sol.add(arr[i]);
        }

        return sol;
    }

    private int bsNearestIndex(int[] arr, int k) {

        int l = 0;
        int r = arr.length - 1;


        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
