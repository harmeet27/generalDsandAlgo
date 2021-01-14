package com.preparation.algorithm.modifiedbinarysearch;

/**
 * Find number of rotations applied on a sorted array
 *
 * 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * sol = find the smallest element and that is your index at which it is sorted.
 * number of rotations = index of minimum element
 */

public class RotatedElement {

    public int findIndexRotatedElement(int[] arr){
        if(arr==null || arr.length<=1){
            return -1;
        }

        int index=-1;

        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
//            if(arr[mid]< arr[mid-1] && arr[mid]< arr[mid+1]){  //this condition will not work for last and first number and may result in array index out of bound
                //to search in rotated manner. we use modulo.

            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length- 1 ) % arr.length; //done so as to avoid - indexing.
            if(arr[mid]<arr[prev] && arr[mid]<arr[next]){
                start=mid;
                break;
            }

            else if(arr[mid]<arr[end]){
                end=mid-1;
            }

            else if(arr[mid]>arr[start]){
                start=mid+1;
            }
        }

        return start;
    }

}
