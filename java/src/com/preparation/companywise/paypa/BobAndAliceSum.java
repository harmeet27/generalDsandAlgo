package com.preparation.companywise.paypa;

/**
 * Problem Statement:
 * <p>
 * A Subarray means the part of the array formed by removing zero or more elements
 * from either side of the array. A Subarray is represented as [X,Y] that means it contains the elements, A[X], A[X+1]......A[Y]
 * <p>
 * There is an Array of size N and given K subarrays.
 * Alice and Bob are asked to find the sum of all the sums obtained from each subarray.
 * Alice works on the given array itself where as
 * Bob wanted to rearrange the array optimally such as the given subarrays would
 * maximise the sum.
 * <p>
 * Find the difference between sums of Bob and Alice.
 * <p>
 * Input:
 * <p>
 * T => no of test cases
 * N, K =>size of array and number of subarrays
 * N integers denoting the array
 * K lines each containing the boundaries of the subarray.
 * Output:
 * <p>
 * Difference between Sum of Bob and Alice
 * Limits:
 * 1<T<=10
 * 0<N,K<=10^5
 * 0<A[i]<=10^5
 * <p>
 * Sample Input:
 * 2
 * 4,3
 * 1,9,1,6
 * 1,1
 * 1,2
 * 1,3
 * 6,7
 * 2,3,5,6,2,6
 * 1,2
 * 1,5
 * 2,6
 * 6,6
 * 5,5
 * 5,5
 * 3,5
 * <p>
 * Output:
 * 5
 * 13
 * <p>
 * <p>
 * <p>
 * NOTE: queries in the test cases are 1-Indexed
 */
public class BobAndAliceSum {

    //Approach:
    //for alice obtain the prefetch sum and using that obtain the result of any range by subtracting arr[start-1] prefetch
    //and arr[end+1]

    //for bob
    //Obtain the frequency of most visited indexes as HashMap<index,Count>.
    //At max indexes place the larger elements and keep continue doing that
    //once you have the final array in place
    //obtain the sum using alice prefetch logic only.
}
