package com.preparation.companywise.arcessium;

import java.util.List;

/**
 * There is a tree with n nodes/ The tree iss rooted at node with number 0. Apple grows on nodes of this tree. Some
 * of these apples are underhydrated, some are overhydrated, and others are neither. You know that for each overhydrated
 * apple you will get overhydrated penalty cents and for every underhydrated you will get underhydrated penalty cents.
 * <p>
 * Now, you want to pour water on exactly one node of the tree. when you pour water on node v, all apples that
 * are in V's subtree with v itself, will be hydrated and in connsequence, each hydrated apple that was almost overhydrated,
 * becomes over hydrated. Moreover, every apple in the whole tree that was almost underhydrated and no water was poured
 * on it gets underhydrated.
 * <p>
 * Calculate the minimum total penalty you can get from puring water on exactly one node of the tree.
 * <p>
 * Function description
 * 1. An int array, parent , of size n, where parenti, denotes parent of ith node.
 * 2. An int array waterlevel, of size n, where waterlevel i , denotes the level of the water in the apple on node i.
 * It's either -1,0,1 where
 * -1 : almost underhydrated
 * 0 : neither of these 2.
 * 1 : almost overhydrated
 * <p>
 * 3. An integer , overHydratedPenalty, denoting the penalty for each overhydrated apple.
 * 4. An integer , underHydratedPenalty, denoting the penalty for each underHydrated apple.
 * <p>
 * OUTPUT: the function must return the min penalty that you can get by puring water exactly on one node of the tree.
 * <p>
 * SAMPLE"
 * 3
 * -1
 * 0
 * 1
 * 3
 * 0
 * 1
 * -1
 * 2
 * 1
 * <p>
 * Sample output: 0
 * Explanation : The best we can do is to pur water on node 2, which is the only underhydarted node and doesnt have any descendats.
 * Thus, it gets hydrated and none of the nodes becomes overhydrated, so the penalty will be 0.
 */
public class HydrateTheNodes {


    static int minPouringWaterPenalty(List<Integer> parents, List<Integer> waterLevel, int overPenalty, int underPenalty) {
        return 0;
    }

    public static void main(String... s) {

    }

}
