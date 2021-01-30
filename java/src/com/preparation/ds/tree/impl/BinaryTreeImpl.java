package com.preparation.ds.tree.impl;

import com.preparation.ds.tree.api.BinaryTree;
import com.preparation.ds.tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Complete Binary Tree
 * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled,
 * and all nodes are as far left as possible. An example of a complete binary tree is:
 * <p>
 * <p>
 * Complexity:
 * Searching: For searching element 2, we have to traverse all elements (assuming we do breadth first traversal).
 * Therefore, searching in binary tree has worst case complexity of O(n).
 * <p>
 * Insertion: For inserting element we have to traverse all elements.
 * Therefore, insertion in binary tree has worst case complexity of O(n).
 * <p>
 * Deletion: For deletion of element 2, we have to traverse all elements to find the element tobe deleted.
 * Therefore, deletion in binary tree has worst case complexity of O(n).
 *
 * @param <E>
 */
public class BinaryTreeImpl<E> implements BinaryTree<E> {

    private BinaryTreeNode<E> root;

    @Override
    public void add(E data) {
        BinaryTreeNode newNode = new BinaryTreeNode(data);
        if (root == null) {
            root = newNode;
            return;
        }

        BinaryTreeNode parentNode = findLastInsertedParentNode();
        if (parentNode.leftChild == null)
            parentNode.leftChild = newNode;
        else
            parentNode.rightChild = newNode;
    }

    @Override
    public boolean search(E data) {
        return search(root, data);
    }

    @Override
    public BinaryTreeNode<E> delete(E data) {
        return null;
    }

    @Override
    public BinaryTreeNode getRoot() {
        return root;
    }

    private BinaryTreeNode findLastInsertedParentNode() {
        Queue<BinaryTreeNode> levelOrder = new LinkedList<>();
        BinaryTreeNode parentElement = null;
        levelOrder.add(root);
        while (!levelOrder.isEmpty()) {
            BinaryTreeNode removedElement = levelOrder.poll();
            if (removedElement.rightChild == null || removedElement.leftChild == null) {
                parentElement = removedElement;
                break;
            }
            levelOrder.add(removedElement.leftChild);
            levelOrder.add(removedElement.rightChild);
        }
        return parentElement;
    }

    private boolean search(BinaryTreeNode root, E data) {
        if (root == null) {
            return false;
        }

        if (root.data.equals(data)) {
            return true;
        }

        return search(root.leftChild, data) | search(root.rightChild, data);
    }

}
