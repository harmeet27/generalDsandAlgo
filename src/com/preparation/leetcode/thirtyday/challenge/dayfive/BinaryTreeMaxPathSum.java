package com.preparation.leetcode.thirtyday.challenge.dayfive;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class BinaryTreeMaxPathSum {
    int max = 0;
    public int maxPathSum(TreeNode root) {
        max=root.val;
        findSum(root);
        return max;
    }

    private int findSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = findSum(root.left);
        int right = findSum(root.right);
        int sum=0;
        if(left>=0 && right>=0){
            sum=left+right+root.val;
        }
        if(left<0){
            sum=right+root.val;
        }
        if(right<0){
            sum=left+root.val;
        }
        if(sum>max){
            max=sum;
        }
        if(left <0 && right<0){
            return root.val;
        }
        return Math.max(left,right)+root.val;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
