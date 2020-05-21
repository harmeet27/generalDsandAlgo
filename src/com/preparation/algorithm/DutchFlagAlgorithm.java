package com.preparation.algorithm;

import java.util.Arrays;

/**
 * sort an array of 0,1,2 in linear time without extra space
 */
public class DutchFlagAlgorithm {


    static void dutchFlag(int[] arr) {
        int curr = 0;
        int two = arr.length;
        int zero = 0;
        //initial Push for zeroes
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                zero = i;
                break;
            } else {
                zero++;
            }
        }

        //intial decline for two's at the end
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 2) {
                two = i;
                break;
            } else {
                two--;
            }
        }

        if (zero == arr.length || two == -1) {
            return;
        }


        curr = zero;
        while (curr <= two && curr >= 0) {
            if (arr[curr] == 0) {
                swap(arr, curr, zero);
                zero++;
            } else if (arr[curr] == 2) {
                swap(arr, curr, two);
                two--;
            } else {
                curr++;
            }
        }


    }

    private static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(x -> System.out.println(x));
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String... s) {
//        int arr[] = new int[]{1, 2, 2, 2, 0, 0, 1, 2, 0};
//        int arr[] = new int[]{2, 0, 0, 1, 0, 0, 1, 2, 2};
        int arr[] = new int[]{ 0, 0, 1, 0, 0, 1, 2, 2};
//        int arr[] = new int[]{0, 0, 0, 0};
//        int arr[] = new int[]{2, 2, 2, 2};
        dutchFlag(arr);
        printArr(arr);
    }
}
