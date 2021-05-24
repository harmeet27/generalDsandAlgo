package com.preparation.coursera.dynamic_connectivity.questions;

/**
 * Given a social network containing nn members and a log file containing mm timestamps at which times pairs of members
 * formed friendships, design an algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend).
 * <p>
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
 * The running time of your algorithm should be m \log nmlogn or better and use extra space proportional to nn.
 * <p>
 * Algorithm : WeightedUnion with modification
 * To find if all the members are connected I used the concept of weighted Quick-union.
 * If the size of tree gets equal to the n then we can say all the members are connected
 */
public class SocialNetwork {
    private int[] id;
    private int[] size;
    private String allConnecetedTimestamp;

    public SocialNetwork(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int x) {
        while (x != id[x]) {
            x = id[x];
        }
        return x;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q, String timestamp) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
            if (size[j] == id.length) {
                allConnecetedTimestamp = timestamp;
            }
        } else {
            id[j] = i;
            size[i] += size[j];
            if (size[i] == id.length) {
                allConnecetedTimestamp = timestamp;
            }
        }
    }

    public static void main(String args[]) {
        SocialNetwork socialNework = new SocialNetwork(6);
        socialNework.union(1, 5, "2019-08-14 18:00:00");
        socialNework.union(2, 4, "2019-08-14 18:00:01");
        socialNework.union(1, 3, "2019-08-14 18:00:02");
        socialNework.union(5, 2, "2019-08-14 18:00:03");
        socialNework.union(0, 3, "2019-08-14 18:00:04");
        socialNework.union(2, 1, "2019-08-14 18:00:05");
        System.out.println(socialNework.allConnecetedTimestamp);

    }
}
