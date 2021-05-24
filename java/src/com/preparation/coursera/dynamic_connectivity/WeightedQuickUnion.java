package com.preparation.coursera.dynamic_connectivity;

/**
 * The idea is to avoid having large trees in Quick union, this is an advancement on top of QuickUnion.
 * <p>
 * We would be reducing the size of the tree by ensuring that always the lower height tree is clubbed to the parent
 * of the big tree. Doing so, the height of the tree even after merging will remain equal to the height of bigger tree.
 * <p>
 * Earlier, in QuickUnion, we were not doing this, and hence there was no guarantee that the tree will not be skewed.
 * <p>
 * Algorithm :
 * we take one more size[] into consideration while performing union.
 * <p>
 * Since the height is better now"
 * TimeComplexity:
 * union : logN
 * isConnected: logN where logN is the height of the tree.
 */
public class WeightedQuickUnion {

    private int[] id;
    private int[] size;

    public WeightedQuickUnion(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = 1;
            id[i] = i;
        }
    }

    //connect their parent so that recursive search can find the common parent in isConnected.
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
        while (current != id[current]) {
            current = id[current];
        }
        return current;
    }

    public static void main(String... s) {
        WeightedQuickUnion WeightedQuickUnion = new WeightedQuickUnion(10); //0-9

        WeightedQuickUnion.union(3, 5);
        WeightedQuickUnion.union(4, 8);
        WeightedQuickUnion.union(3, 8);
        WeightedQuickUnion.union(1, 9);
        WeightedQuickUnion.union(2, 8);
        WeightedQuickUnion.union(4, 8);
        System.out.println(WeightedQuickUnion.isConnected(4, 5));
        System.out.println(WeightedQuickUnion.isConnected(3, 8));
        System.out.println(WeightedQuickUnion.isConnected(4, 8));
        System.out.println(WeightedQuickUnion.isConnected(1, 9));
        System.out.println(WeightedQuickUnion.isConnected(2, 8));
        System.out.println(WeightedQuickUnion.isConnected(4, 8));
        System.out.println(WeightedQuickUnion.isConnected(9, 3));

    }
}
