package com.preparation.ds.tree.quest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindNodeAtK {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<TreeNode> parentsOverall = new LinkedList();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findAncestors(root, target, new LinkedList());
        List<Integer> solution = new LinkedList();

        System.out.println("parents");
        parentsOverall.forEach(node -> System.out.print(" " + node.val));

        //For each parent of target node, find all nodes k-distance apart where distance
        //is how far parent itself from target.
        int size=parentsOverall.size();
        for (int i = 0; i < size - 1; i++) {
            int distance = size - i - 1;
            TreeNode currentParent = parentsOverall.get(i);
            if (distance < k) {
                if (currentParent.left != null && currentParent.left == parentsOverall.get(i + 1)) {
                    solution.addAll(nodesAtK(currentParent.right, (k - distance - 1)));
                } else {
                    solution.addAll(nodesAtK(currentParent.left, (k - distance - 1)));
                }

            } else if (distance == k) {
                solution.add(currentParent.val);
            }
        }

        //Find all nodes which are k distance apart from target in its subtree.
        solution.addAll(nodesAtK(parentsOverall.get(size - 1), k));
        return solution;

    }


    private static void findAncestors(TreeNode root, TreeNode target, List<TreeNode> parents) {
        if (root == null)
            return;

        parents.add(root);

        if (target == root) {
            parentsOverall = parents;
            return;
        }

        List<TreeNode> leftParents = new LinkedList();
        List<TreeNode> rightParents = new LinkedList();

        leftParents.addAll(parents);
        rightParents.addAll(parents);
        findAncestors(root.left, target, leftParents);
        findAncestors(root.right, target, rightParents);
    }


    private static List<Integer> nodesAtK(TreeNode target, int k) {
        if (target == null) {
            return new LinkedList();
        }

        if (k == 0) {
            return Arrays.asList(target.val);
        }

        List<Integer> leftNodes = nodesAtK(target.left, k - 1);
        List<Integer> rightNodes = nodesAtK(target.right, k - 1);

        List<Integer> allNodes = new LinkedList();
        allNodes.addAll(leftNodes);
        allNodes.addAll(rightNodes);
        return allNodes;

    }

    public static void main(String... s) {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode0.left = treeNode2;
        treeNode0.right = treeNode1;
        treeNode1.left = treeNode3;

        distanceK(treeNode0, treeNode3, 3);
    }
}
