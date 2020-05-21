package com.preparation.companywise.airtel;

import java.util.Scanner;

public class PowerfulIndex {
    public static void main(String args[]) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input
         */

        //Scanner
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int size = s.nextInt();
            int array[] = new int[size];
            int i = 0;
            while (size > 0) {
                array[i] = s.nextInt();
                size--;
                i++;
            }

            System.out.println(findPiElement(array));
            t--;
        }


    }

    static int findPiElement(int[] array) {
        // Write your code here
        int maxPi = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int[] left = findLeftGreaterAndSmaller(i, array);
            int[] right = findLeftGreaterAndSmaller(i, array);
            int count = left[0] + left[1] + right[0] + right[1];
            if (count > maxPi) {
                maxPi = count;
                index = i;
            }
        }
        return index;
    }

    static int[] findLeftGreaterAndSmaller(int element, int[] array) {
        int leftGreater = 0;
        int leftSmaller = 0;
        for (int i = 0; i < element; i++) {
            if (array[i] < array[element]) {
                leftSmaller++;
            } else if (array[i] > array[element]) {
                leftGreater++;
            }
        }

        int[] left = new int[2];
        left[0] = leftSmaller;
        left[1] = leftGreater;
        return left;
    }

    static int[] findRighGreaterAndSmaller(int element, int[] array) {
        int rightGreater = 0;
        int rightSmaller = 0;
        for (int i = element + 1; i < array.length; i++) {
            if (array[i] < array[element]) {
                rightSmaller++;
            } else if (array[i] > array[element]) {
                rightGreater++;
            }
        }

        int[] right = new int[2];
        right[0] = rightSmaller;
        right[1] = rightGreater;
        return right;
    }
}
