package com.preparation.algorithm.modifiedbinarysearch;

/**
 * To find 1st and last occurence in a sorted array of an element.
 *
 * Idea is to find first occurence, after finding a occurence of an element, dont terminate the search. move your end to mid-1
 * and keep searching for the occurence and update the 1stOccurence variable with the value found.
 *
 * To find lastOccurence:
 * same logic as above, jst update the start=mid+1 and keep searching.
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 */
public class FindFirstAndLastOccurenceInASortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }

        if(nums.length==1){
            if(nums[0]==target){
                return new int[]{0,0};
            }
            return new int[]{-1,-1};
        }
        int fo=firstOccurence(nums,target);
        int lo=lastOccurence(nums,target);
        return new int[]{fo,lo};
    }

    public int firstOccurence(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        int first=-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                first=mid; //update the firstOccurence found earlier.
                end=mid-1; //keep searching in the left even though the val is found.
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
        }
        return first;
    }

    public int lastOccurence(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        int last=-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                last=mid; //update the last occurence found earlier.
                start=mid+1; //keep searching even though is found.
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
        }
        return last;
    }
}
