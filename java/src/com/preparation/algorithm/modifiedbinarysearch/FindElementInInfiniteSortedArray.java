package com.preparation.algorithm.modifiedbinarysearch;

/**
 * Issue in this question is we dont know the end since it is infinite.
 * So what we do we assume that the 1st index is end. If not, we keep increasing our end window by twice of the value;
 * <p>
 * once the element comes in the range of start and end, we apply binarySearch.
 */
public class FindElementInInfiniteSortedArray {

    public int findElementIndex(int[] arr, int element) {
        int start = 0;
        int end = 1;
        int pos = -1;

        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            if (arr[0] == element) {
                return 0;
            }
            return -1;
        }


        while (arr[end] < element) {
            start = end;
            end = end * 2;
        }


        //once start and end is found in between which the element is present. Solve it by applying normal binary search
        //binarySearch(start,end, element);
        return pos;
    }
}
