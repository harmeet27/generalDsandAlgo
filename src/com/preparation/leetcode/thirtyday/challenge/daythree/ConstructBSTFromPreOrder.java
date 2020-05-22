package com.preparation.leetcode.thirtyday.challenge.daythree;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 * <p>
 * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
 * <p>
 * Example 1:
 * <p>
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 10^8
 * The values of preorder are distinct.
 */
public class ConstructBSTFromPreOrder {

    class TreeNode {
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

    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            TreeNode root = new TreeNode(preorder[0], null, null);
            buildBST(root, preorder, 1, preorder.length - 1);
            return root;
        }

        void buildBST(TreeNode root, int[] preOrder, int start, int end) {
            if (start > end || end > preOrder.length) {
                return;
            }

            if (start == end) {
                if (preOrder[start] >= root.val) {
                    root.right = new TreeNode(preOrder[start], null, null);
                } else {
                    root.left = new TreeNode(preOrder[start], null, null);
                }

                return;
            }


            int rightStart = -1;
            for (int i = start; i <= end; i++) {
                if (preOrder[i] >= root.val) {
                    rightStart = i;
                    break;
                }
            }


            if (rightStart == -1) {
                root.left = new TreeNode(preOrder[start], null, null);
                buildBST(root.left, preOrder, start + 1, end);
            } else if (rightStart == start) {
                root.right = new TreeNode(preOrder[start], null, null);
                buildBST(root.right, preOrder, start + 1, end);
            } else {
                root.left = new TreeNode(preOrder[start], null, null);
                root.right = new TreeNode(preOrder[rightStart], null, null);
                buildBST(root.left, preOrder, start + 1, rightStart - 1);
                buildBST(root.right, preOrder, rightStart + 1, end);
            }

        }
    }
}
