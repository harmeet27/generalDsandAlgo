package com.preparation.ds.list.questions;

/**
 * Similar to Flatten a Linkedlist with child node.
 * only changes here it is a LinkedList not doubly
 * Consider left here as child
 * right here as next
 * <p>
 * and the same solution will work;
 */
public class FlattenTreeLL {

    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    //child is left , right is next
    private TreeNode flattenTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.left == null) {
            return flattenTree(root.right);
        } else {
            TreeNode tail = flattenTree(root.left);
            if (root.right != null) {
                TreeNode rootRight = root.right;
                root.right = root.left;
                tail.right = rootRight;
                root.left = null;
                return flattenTree(rootRight);

            } else {
                root.right = root.left;
                root.left = null;
                return tail;
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
