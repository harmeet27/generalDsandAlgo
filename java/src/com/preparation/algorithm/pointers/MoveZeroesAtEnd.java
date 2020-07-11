package com.preparation.algorithm.pointers;

public class MoveZeroesAtEnd {
    public void moveZeroes(int[] nums) {
        int nonIndex = -1;
        int zeroIndex = -1;

        //intial push
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zeroIndex == -1) {
                zeroIndex = i;
            }
        }
        nonIndex = zeroIndex;

        if (nonIndex >= nums.length) {
            return;
        }

        while (zeroIndex >= 0 && zeroIndex < nums.length && nonIndex >= 0 && nonIndex < nums.length) {
            if (nums[zeroIndex] != 0) {
                zeroIndex = findZeroindex(nums, zeroIndex);
            }
            if (nums[nonIndex] == 0) {
                nonIndex = findNonindex(nums, zeroIndex);
            }
            if (zeroIndex == -1 || nonIndex == -1) {
                break;
            }
            swap(zeroIndex, nonIndex, nums);
            zeroIndex++;
            nonIndex++;
        }

    }

    private void swap(int i, int j, int[] nums) {
        if (i >= nums.length || j >= nums.length || i < 0 || j < 0) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int findZeroindex(int[] nums, int currIndex) {
        for (int i = currIndex + 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private int findNonindex(int[] nums, int currIndex) {
        for (int i = currIndex + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] s) {
        int[] sample = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        MoveZeroesAtEnd a = new MoveZeroesAtEnd();
        a.moveZeroes(sample);
        for (int i = 0; i < sample.length; i++) {
            System.out.print(sample[i] +
                    " ");
        }
    }
}
