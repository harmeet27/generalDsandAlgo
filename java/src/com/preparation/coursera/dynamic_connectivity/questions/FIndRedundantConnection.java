package com.preparation.coursera.dynamic_connectivity.questions;

/**
 * https://leetcode.com/problems/redundant-connection
 */
public class FIndRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int[] solution = new int[2];
        UnionFind unionFind = new UnionFind(1001);
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (unionFind.isConnected(edge[0], edge[1])) {
                solution = edge;
            } else {
                unionFind.union(edge[0], edge[1]);
            }
        }
        return solution;
    }

    class UnionFind {
        int[] arr;
        int[] size;

        UnionFind(int data) {
            arr = new int[data];
            size = new int[data];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
                size[i] = 1;
            }

        }

        private void union(int p, int q) {
            int pRoot = getParent(p);
            int qRoot = getParent(q);

            if (size[p] < size[q]) {
                size[q] += size[p];
                arr[pRoot] = qRoot;
            } else {
                arr[qRoot] = pRoot;
                size[p] += size[q];
            }

        }

        private boolean isConnected(int p, int q) {
            return getParent(p) == getParent(q);
        }

        private int getParent(int p) {
            while (p != arr[p]) {
                p = arr[p];
            }
            return p;
        }

    }
}
