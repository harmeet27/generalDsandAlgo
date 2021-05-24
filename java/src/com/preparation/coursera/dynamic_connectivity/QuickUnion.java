package com.preparation.coursera.dynamic_connectivity;

/**
 * QuickUnion : as the name suggest dont change all the child value of q node to p, instead find the root node of
 * p&q rescpectively and connect a path between them.
 * <p>
 * isConnected : will check if both p & q has the same common root node.
 * <p>
 * TimeComplexity : Union : o(N) : since in worst case a tree can be a flat/skewed tree.
 * isConnected : o(N) : slower than QuickFind.
 */
public class QuickUnion {
    private int[] id;

    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    //connect their parent so that recursive search can find the common parent in isConnected.
    public void union(int p, int q) {
        int pRoot = getParent(p);
        int qRoot = getParent(q);
        id[pRoot] = qRoot;
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
        QuickUnion quickUnion = new QuickUnion(10); //0-9

        quickUnion.union(3, 5);
        quickUnion.union(4, 8);
        quickUnion.union(3, 8);
        quickUnion.union(1, 9);
        quickUnion.union(2, 8);
        quickUnion.union(4, 8);
        System.out.println(quickUnion.isConnected(4, 5));
        System.out.println(quickUnion.isConnected(3, 8));
        System.out.println(quickUnion.isConnected(4, 8));
        System.out.println(quickUnion.isConnected(1, 9));
        System.out.println(quickUnion.isConnected(2, 8));
        System.out.println(quickUnion.isConnected(4, 8));
        System.out.println(quickUnion.isConnected(9, 3));

    }
}
