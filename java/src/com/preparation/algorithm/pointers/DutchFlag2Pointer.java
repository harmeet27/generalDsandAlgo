package com.preparation.algorithm.pointers;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class DutchFlag2Pointer {

    public void sortColors(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        int zp = 0;
        int tp = array.length - 1;

        while (zp < array.length && array[zp] == 0) zp++;
        while (tp >= 0 && array[tp] == 2) tp--;

        int curr = zp;

        while (curr <= tp) {
            if (array[curr] == 0) {
                swap(zp, curr, array);
                curr++;
                zp++;
            } else if (array[curr] == 2) {
                swap(tp, curr, array);
                tp--;
            } else {
                curr++;
            }
        }
    }

    private void swap(int first, int second, int[] array) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
