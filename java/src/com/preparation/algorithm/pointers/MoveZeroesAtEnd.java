package com.preparation.algorithm.pointers;

/**
 *
 * Maintaining the order of remaning elements
 *
 * Keep a track of zp --> first zero encountered from left;
 */
public class MoveZeroesAtEnd {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zp = 0;
        while (zp < nums.length && nums[zp] != 0) zp++;

        int curr = zp;
        while (curr < nums.length) {
            if (nums[curr] != 0) {
                //swap
                int temp = nums[zp];
                nums[zp] = nums[curr];
                nums[curr] = temp;
                zp++;
            }
            curr++;
        }
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
