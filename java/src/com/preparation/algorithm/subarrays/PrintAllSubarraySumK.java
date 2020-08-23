package com.preparation.algorithm.subarrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Remember for printing you need a HAshMap<Key,List>
 * since that previous sum which you are checking in map, could be encountered at multiple places.
 * if longest then only store the index of first occurence of that sum.
 * if count of such subarray use counter
 * if all are needed list is needed. See the below example:
 * <p>
 * A[] = {3,4,-7,1,3,3,1,-4}\
 * k=7;
 * <p>
 * subarrays with given k:
 * 3,4
 * 3,3,1
 * 3,4,-7,1,3,3
 * 1,3,3
 * <p>
 * if you will not update the sum 0 with multiple ocuurence of it you will not find the 1,3,3 subarray in above case.
 */
public class PrintAllSubarraySumK {

    public static void printAllSubArray(int[] A, int k) {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        insert(hashMap, 0, -1);

        int currSum = 0;

        for (int i = 0; i < A.length; i++) {
            currSum += A[i];
            if (hashMap.containsKey(currSum - k)) {
                List<Integer> allStartIndexes = hashMap.get(currSum - k);
                for (Integer index : allStartIndexes)
                    printSubArray(A, index + 1, i);
            }

            insert(hashMap, currSum, i);
        }
    }


    private static <K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }
        hashMap.get(key).add(value);
    }

    private static void printSubArray(int[] A, int i, int j) {
        System.out.println(IntStream.range(i, j + 1).mapToObj(k -> A[k]).collect(Collectors.toList()));
    }

    public static void main(String... s) {
        int A[] = {3, 4, -7, 1, 3, 3, 1, -4};
        int k = 7;

        printAllSubArray(A, k);
    }


}
