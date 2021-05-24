package com.preparation.ds.tree.quest;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class VerticalTraversalWithModification {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> solution = new LinkedList();

        Map<Integer, PriorityQueue<LevelNode>> records = new TreeMap();
        traverse(root, 0, 0, records);

        for (Map.Entry<Integer, PriorityQueue<LevelNode>> record : records.entrySet()) {
            PriorityQueue<LevelNode> queue = record.getValue();
            List<Integer> sameLevelNodes = new LinkedList();
            while (!queue.isEmpty()) {
                sameLevelNodes.add(queue.poll().element);
            }
            solution.add(sameLevelNodes);
        }

        return solution;
    }

    private void traverse(TreeNode root, int level, int height, Map<Integer, PriorityQueue<LevelNode>> records) {
        if (root == null) return;

        PriorityQueue<LevelNode> nodesAtSameLevel = records.getOrDefault(level, new PriorityQueue<LevelNode>(new LevelNodeComparator()));

        nodesAtSameLevel.add(new LevelNode(root.val, level, height));
        records.put(level, nodesAtSameLevel);
        if (root.left != null) {
            traverse(root.left, level - 1, height + 1, records);
        }
        if (root.right != null) {
            traverse(root.right, level + 1, height + 1, records);
        }

    }

    class LevelNodeComparator implements Comparator<LevelNode> {

        public int compare(LevelNode f, LevelNode s) {
            if (f.y < s.y) return -1;
            if (f.y > s.y) return 1;
            if (f.element < s.element) return -1;
            if (f.element > s.element) return 1;
            return 0;
        }
    }

    class LevelNode {
        int element;
        //representing which level
        int x;
        //height from top
        int y;

        LevelNode(int element, int x, int y) {
            this.element = element;
            this.x = x;
            this.y = y;
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

}
