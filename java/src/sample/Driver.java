package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;


public class Driver {


//    static int[] absSort(int[] arr) {
//        Arrays.sort(arr, new CustomComparator());
//        return arr;
//        // your code goes here
//    }

    static class CustomComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            int element1 = (int) o1;
            int element2 = (int) o2;

            int first = Math.abs(element1);
            int second = Math.abs(element2);


            if (first < second) {
                return -1;
            } else if (first > second) {
                return 1;
            } else {
                if (element1 < element2) return -1;
                else if (element2 < element1) return 1;
                else return 0;
            }
        }
    }

//    public static void main(String[] args) {
//
////        int arr[] = new int[]{4,2,5,8,7,3,7};
////        int arr[] = new int[]{5,5,5,5,5,5};
////        int arr[] = new int[]{14, 24, 17, 24, 22};
//        int arr[] = new int[]{14, 21,16,35,22};
//        System.out.println(findPairEvenSum(arr));
//    }

    public static int findPairEvenSum(int[] arr) {

        if (arr == null || arr.length < 2) {
            return 0;
        }
        boolean firstVisited = false;
        boolean secondVisited = false;

        int count = 0;
        int i = 1;
        while (i < arr.length) {
            if ((arr[i] + arr[i - 1]) % 2 == 0) {
                if (i == 1) {
                    firstVisited = true;
                    secondVisited = true;
                }
                count++;
                i += 2;
            } else {
                i++;
            }
        }

        if ((arr[0] + arr[arr.length - 1]) % 2 == 0 && !firstVisited && !secondVisited) {
            count++;
        }

        return count;
    }


    static int evenSumK(int arr[], int N, int K)
    {

        // If count of elements
        // is less than K



        if (K > N) {
            return -1;
        }

        // Stores maximum even
        // subsequence sum
        int maxSum = 0;

        // Stores Even numbers
        ArrayList<Integer> Even = new ArrayList<Integer>();

        // Stores Odd numbers
        ArrayList<Integer> Odd = new ArrayList<Integer>();

        // Traverse the array
        for (int i = 0; i < N; i++) {

            // If current element
            // is an odd number
            if (arr[i] % 2 == 1) {

                // Insert odd number
                Odd.add(arr[i]);
            }
            else {

                // Insert even numbers
                Even.add(arr[i]);
            }
        }

        // Sort Odd[] array
        Collections.sort(Odd);

        // Sort Even[] array
        Collections.sort(Even);





        // Stores current index
        // Of Even[] array
        int i = Even.size() - 1;

        // Stores current index
        // Of Odd[] array
        int j = Odd.size() - 1;


        if(i==0 && j==0 && K>1){
            //only 1 elements
            return -1;

        }


        while (K > 0) {

            // If K is odd
            if (K % 2 == 1) {

                // If count of elements
                // in Even[] >= 1
                if (i >= 0) {

                    // Update maxSum
                    maxSum += Even.get(i);

                    // Update i
                    i--;
                }

                // If count of elements
                // in Even[] array is 0.
                else {
                    return -1;
                }

                // Update K
                K--;
            }

            // If count of elements
            // in Even[] and odd[] >= 2
            else if (i >= 1 && j >= 1) {
                if (Even.get(i) + Even.get(i - 1)
                        <= Odd.get(j) + Odd.get(j - 1)) {

                    // Update maxSum
                    maxSum += Odd.get(j) + Odd.get(j - 1);

                    // Update j
                    j -= 2;
                }
                else {

                    // Update maxSum
                    maxSum += Even.get(i) + Even.get(i - 1);

                    // Update i
                    i -= 2;
                }

                // Update K
                K -= 2;
            }

            // If count of elements
            // in Even[] array >= 2.
            else if (i >= 1) {

                // Update maxSum
                maxSum += Even.get(i) + Even.get(i - 1);

                // Update i
                i -= 2;

                // Update K
                K -= 2;
            }

            // If count of elements
            // in Odd[] array >= 1
            else if (j >= 1) {

                // Update maxSum
                maxSum += Odd.get(j) + Odd.get(j - 1);

                // Update i.
                j -= 2;

                // Update K.
                K -= 2;
            }
        }
        return maxSum;
    }

    // Driver code
    public static void main(String[] args)
    {
//        int arr[] = { 1,2 };
//        int N = arr.length;
//        int K = 2;

//        int arr[] = { 5,6,3,4,2 };
//        int N = arr.length;
//        int K = 5;

        int arr[] = { 1,2 };
        int N = arr.length;
        int K = 1;

        System.out.println(evenSumK(arr, N, K));
    }


}
