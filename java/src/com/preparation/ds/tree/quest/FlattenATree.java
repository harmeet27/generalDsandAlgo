package com.preparation.ds.tree.quest;

import java.util.Stack;

/**
 * Convert a given Binary Tree to Doubly Linked List | Set 3
 * Difficulty Level : Hard
 *  Last Updated : 29 Aug, 2019
 * Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (left most node in BT) must be head node of the DLL.
 *
 * SOLUTION:
 * 1. Find inorder traversal and store it in a linked list.
 *      Now traverse the linkedlist assigning next and prev to each node.
 *      Time: o(n)
 *      space: o(n)
 *
 * 2. Efficient Approach:
 *          findPredecessor &
 *          findSuccessor for each node
 */
public class FlattenATree {

    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        // Write your code here.
        if(root==null){
            return root;
        }
        BinaryTree[] vals = flatten(root);
        return vals[0];
    }

    private static BinaryTree[] flatten(BinaryTree root){
        BinaryTree left=null;
        BinaryTree right=null;
        if(root.left!=null){
            BinaryTree[] rightMostFromLeft = flatten(root.left);
            left=rightMostFromLeft[0];
            arrange(rightMostFromLeft[1],root);
        }else{
            left=root;
        }

        if(root.right!=null){
            BinaryTree[] leftMostFromRight = flatten(root.right);
            right=leftMostFromRight[1];
            arrange(root,leftMostFromRight[0]);
        }else{
            right=root;
        }

        return new BinaryTree[]{left,right};
    }

    private static void arrange(BinaryTree first, BinaryTree second){
        first.right=second;
        second.left=first;
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}