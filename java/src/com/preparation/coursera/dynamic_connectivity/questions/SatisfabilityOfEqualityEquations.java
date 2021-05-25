package com.preparation.coursera.dynamic_connectivity.questions;

/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 * <p>
 * Given an array equations of strings that represent relationships between variables, each string equations[i] has
 * length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters
 * (not necessarily different) that represent one-letter variable names.
 * <p>
 * Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given
 * equations.
 * <p>
 * Example 1:
 * <p>
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.
 * Example 2:
 * <p>
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * Example 3:
 * <p>
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 * Example 4:
 * <p>
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 * Example 5:
 * <p>
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] and equations[i][3] are lowercase letters
 * equations[i][1] is either '=' or '!'
 * equations[i][2] is '='
 */
public class SatisfabilityOfEqualityEquations {

    public boolean equationsPossible(String[] equations) {

        UnionFind unionFind = new UnionFind(26);

        for (int i = 0; i < equations.length; i++) {

            char[] equation = equations[i].toCharArray();

            char op1 = equation[1];
            char op2 = equation[2];

            char operand1 = equation[0];
            char operand2 = equation[3];

            if ((op1 == '=' && op2 == '=')) {
                unionFind.union(operand1, operand2);
            }
        }


        boolean valid = true;

        for (int i = 0; i < equations.length; i++) {
            char[] equation = equations[i].toCharArray();

            char op1 = equation[1];
            char op2 = equation[2];

            char operand1 = equation[0];
            char operand2 = equation[3];


            if ((op1 == '=' && op2 == '=')) {
                valid = valid & unionFind.isConnected(operand1, operand2);
            } else {
                valid = valid & (!unionFind.isConnected(operand1, operand2));
            }
        }

        return valid;

    }


    class UnionFind {
        int[] arr;
        int[] size;

        UnionFind(int totalNodes) {
            arr = new int[totalNodes];
            size = new int[totalNodes];

            for (int i = 0; i < totalNodes; i++) {
                size[i] = 1;
                arr[i] = i;
            }
        }

        public void union(char a, char b) {
            int aIndex = a - 'a';
            int bIndex = b - 'a';

            int aRoot = getRoot(aIndex);
            int bRoot = getRoot(bIndex);

            if (size[aRoot] < size[bRoot]) {

                size[bRoot] += size[aRoot];
                arr[aRoot] = bRoot;
            } else {
                size[aRoot] += size[bRoot];
                arr[bRoot] = aRoot;
            }
        }

        public boolean isConnected(char a, char b) {
            int aIndex = a - 'a';
            int bIndex = b - 'a';

            int aRoot = getRoot(aIndex);
            int bRoot = getRoot(bIndex);
            return arr[aRoot] == arr[bRoot];
        }

        private int getRoot(int index) {
            while (index != arr[index]) {
                arr[index] = arr[arr[index]];
                index = arr[index];
            }
            return index;
        }
    }
}
