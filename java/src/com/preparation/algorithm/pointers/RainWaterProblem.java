package com.preparation.algorithm.pointers;

import java.util.Arrays;

public class RainWaterProblem {

    public static int solveRainWater(int arr[]) {
        int lMax[] = new int[arr.length];
        int rMax[] = new int[arr.length];

        int waterStored = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            lMax[i] = max;
        }

        max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
            }
            rMax[i] = max;
        }


        for (int i = 0; i < arr.length; i++) {
            int water = (Math.min(lMax[i], rMax[i]) - arr[i]);
            if (water > 0) {
                waterStored += water;
            }
        }

        return waterStored;

    }

    private static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(x -> System.out.println(x));
    }

    public static void main(String... s) {
//        int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int arr[] = new int[]{3, 0, 2, 0, 4};
        System.out.println(solveRainWater(arr));

    }
}
