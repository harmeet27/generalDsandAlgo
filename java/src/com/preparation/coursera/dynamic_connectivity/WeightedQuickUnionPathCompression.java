package com.preparation.coursera.dynamic_connectivity;

/**
 * Advancement on top of weighted quick union: while finding the root of a node, point all the parents of p to root as well.
 * this will help in keeping the height of tree minimum(almost 1 level).
 */
public class WeightedQuickUnionPathCompression {
    int id[];
    int size[];

    public void union(int p, int q) {
        int pRoot = getParent(p);
        int qRoot = getParent(q);
        if (pRoot == qRoot) return;

        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }

    //find root parent and check if they are same , instead of precalculating the root parent in quick find.
    public boolean isConnected(int p, int q) {
        int pRoot = getParent(p);
        int qRoot = getParent(q);
        return pRoot == qRoot;
    }

    private int getParent(int current) {
        int currentId = id[current];
        while (currentId != current) {
            //Extra line of code
            id[current] = id[id[current]];

            currentId = id[currentId];
            current = id[currentId];
        }

        return current;
    }
}
