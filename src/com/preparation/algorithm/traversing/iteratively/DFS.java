package com.preparation.algorithm.traversing.iteratively;

import java.util.Arrays;
import java.util.Stack;

/**
 * The only difference between iterative DFS and recursive DFS is that the recursive stack is replaced by a stack of nodes.
 * <p>
 * <p>
 * <p>
 * Algorithm:
 * 1. Created a stack of nodes and visited array.
 * 2. Insert the root in the stack.
 * 3. Run a loop till the stack is not empty.
 * 4. Pop the element from the stack and print the element.
 * 5. For every adjacent and unvsisted node of current node, mark the node and insert it in the stack.
 * <p>
 * <p>
 * Implementation of Iterative DFS: This is similar to BFS, the only difference is queue is replaced by stack.
 */
public class DFS {
    public static int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1.toCharArray(), text2.toCharArray());
    }

    static int lcs(char[] text1, char[] text2) {

        Stack<Node> stack = new Stack();
        stack.add(new Node(text1.length - 1, text2.length - 1, 0));
        int max = 0;
        int[][] records = new int[text1.length][text2.length];
        for (int i = 0; i < records.length; i++) {
            for (int j = 0; j < records[0].length; j++) {
                records[i][j] = -1;
            }
        }


        while (!stack.isEmpty()) {


            Node element = stack.pop();

            if (element.n >= 0 && element.m >= 0) {
                if (records[element.n][element.m] != -1) {
                    if (records[element.n][element.m] < element.count) {
                        records[element.n][element.m] = element.count;
                    }
                    continue;
                }

                if (text1[element.n] == text2[element.m]) {
                    int count = element.count + 1;
                    stack.add(new Node(element.n - 1, element.m - 1, count));
                    if (max < count) {
                        max = count;
                    }
                } else {
                    stack.add(new Node(element.n - 1, element.m, element.count));
                    stack.add(new Node(element.n, element.m - 1, element.count));
                }
                records[element.n][element.m] = stack.peek().count;
            }

        }
        return max;
    }

    static class Node {
        int n;
        int m;
        int count;

        Node(int n, int m, int count) {
            this.n = n;
            this.m = m;
            this.count = count;
        }
    }

    public static void main(String... s) {
//        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("pmjghexybyrgzczy",
                "hafcdqbgncrcbihkd"));
    }
}
