package com.preparation.algorithm.dp.grokkingDPPattern.knapsack01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Perfect Sum Problem (Print all subsets with given sum)
 * <p>
 * Given an array of integers and a sum, the task is to print all subsets of given array with sum equal to given sum.
 * <p>
 * Examples:
 * <p>
 * Input : arr[] = {2, 3, 5, 6, 8, 10}
 * sum = 10
 * Output : 5 2 3
 * 2 8
 * 10
 * <p>
 * Input : arr[] = {1, 2, 3, 4, 5}
 * sum = 10
 * Output : 4 3 2 1
 * 5 3 2
 * 5 4 1
 */
public class CountOfSubsetSum {


    public static void main(String... s) {
        int arr[] = new int[]{2, 3, 5, 6, 8, 10};
        int k = 10;
        List<Integer> solution = findAllSubsets(arr, k);

        solution.stream().forEach(element -> {
            if (element != Integer.MAX_VALUE) {
                System.out.print(element + " ");
            }
        });
    }

    private static List<Integer> findAllSubsets(int[] arr, int k) {

        HashMap<String, List<Integer>> memo = new HashMap<>();
        return findAllSubsets(arr, k, 0, 0, new LinkedList(), memo);

    }

    private static List<Integer> findAllSubsets(int[] arr, int k, int index, int sum, List<Integer> list, HashMap<String, List<Integer>> memo) {

        String key = index + "-" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (sum == k) {
            list.forEach(x -> System.out.print(x + " "));
            System.out.println();
            return list;
        }

        if (index == arr.length) {
            return null;
        }

        List<Integer> includedList = new LinkedList<>();
        List<Integer> excluedList = new LinkedList<>();
        includedList.addAll(list);
        excluedList.addAll(list);

        if (sum <= k) {
            includedList.add(arr[index]);
            includedList = findAllSubsets(arr, k, index + 1, sum + arr[index], includedList, memo);
        } else {
            includedList = null;
        }
        excluedList = findAllSubsets(arr, k, index + 1, sum, excluedList, memo);

        List<Integer> solution = new LinkedList<>();
        if (includedList != null) {
            solution.addAll(includedList);
        }

        if (excluedList != null) {
            solution.add(Integer.MAX_VALUE);
            solution.addAll(excluedList);

        }

        solution.add(Integer.MAX_VALUE);
        memo.put(key, solution);
        return solution;

    }
}
