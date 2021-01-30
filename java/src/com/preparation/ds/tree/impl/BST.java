package com.preparation.ds.tree.impl;

import com.preparation.ds.tree.api.BinaryTree;
import com.preparation.ds.tree.model.BinaryTreeNode;

import java.util.Comparator;


/**
 * Insertion : o(logn) or h where h is height of the tree.
 * search : o(logn)
 * deletion : o(logn) since which children to replace it with can be in o(logn) in worst time.
 *
 * @param <E>
 */

public class BST<E extends Comparable> implements BinaryTree<E> {

    private BinaryTreeNode<E> root;
    private Comparator<BinaryTreeNode<E>> userComparator;

    public BST() {
    }

    public BST(Comparator<BinaryTreeNode<E>> comparator) {
        this.userComparator = comparator;
    }

    @Override
    public void add(E data) {
        BinaryTreeNode<E> newNode = new BinaryTreeNode(data);
        if (root == null) {
            root = newNode;
            return;
        }
        if (userComparator == null) {
            insertBinaryTree(root, newNode);
        } else {
            insertBinaryTree(root, newNode, userComparator);
        }
    }

    @Override
    public boolean search(E data) {
        if (root == null) {
            return false;
        }
        BinaryTreeNode searchedNode = binarySearchTree(root, data);
        return searchedNode == null ? false : true;
    }

    @Override
    public BinaryTreeNode<E> delete(E data) {

        BinaryTreeNode<E> elementNode = binarySearchTree(root, data);
        if (elementNode == null)
            throw new RuntimeException("Data does not exist in tree: " + data);

        return delete(elementNode);
    }

    @Override
    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    private void insertBinaryTree(BinaryTreeNode root, BinaryTreeNode<E> newNode) {
        if (newNode.data.compareTo(root.data) >= 0) {
            if (root.rightChild == null)
                root.rightChild = newNode;
            else
                insertBinaryTree(root.rightChild, newNode);
        } else {
            if (root.leftChild == null)
                root.leftChild = newNode;
            else
                insertBinaryTree(root.leftChild, newNode);
        }
    }

    private void insertBinaryTree(BinaryTreeNode<E> root, BinaryTreeNode<E> newNode, Comparator<BinaryTreeNode<E>> userComparator) {
        if (userComparator.compare(newNode, root) >= 0) {
            if (root.rightChild == null)
                root.rightChild = newNode;
            else
                insertBinaryTree(root.rightChild, newNode, userComparator);
        } else {
            if (root.leftChild == null)
                root.leftChild = newNode;
            else
                insertBinaryTree(root.leftChild, newNode, userComparator);
        }
    }

    private BinaryTreeNode binarySearchTree(BinaryTreeNode<E> current, E data) {
        if (current == null) {
            return null;
        }

        if (current.data.equals(data))
            return root;

        if (current.data.compareTo(data) > 0) {
            return binarySearchTree(current.leftChild, data);
        }
        return binarySearchTree(current.rightChild, data);
    }

    private BinaryTreeNode<E> delete(BinaryTreeNode<E> nodeToDelete) {
        BinaryTreeNode<E> deletedElement = null;
        if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {

        } else if (nodeToDelete.leftChild != null && nodeToDelete.rightChild != null) {
            BinaryTreeNode<E> preDecessor = findPredecessor(nodeToDelete.leftChild);
            swap(nodeToDelete,preDecessor);
        } else if (nodeToDelete.leftChild != null) {
            swap(nodeToDelete, nodeToDelete.leftChild);
            deletedElement = nodeToDelete;
        } else {
            swap(nodeToDelete, nodeToDelete.rightChild);
            deletedElement = nodeToDelete;
        }

        return deletedElement;
    }

    private BinaryTreeNode<E> findPredecessor(BinaryTreeNode<E> nodeToDelete) {
        if (nodeToDelete.rightChild != null) {
            return findPredecessor(nodeToDelete.rightChild);
        } else {
            return nodeToDelete;
        }
    }

    private void swap(BinaryTreeNode<E> first, BinaryTreeNode<E> second) {
        first.data = second.data;
        first.leftChild = second.leftChild;
        first.rightChild = second.rightChild;

        second.leftChild = null;
        second.rightChild = null;
        second.data = null;
    }

    private void swapBothChild(BinaryTreeNode<E> first, BinaryTreeNode<E> second) {
        first.data = second.data;
        first.leftChild = second.leftChild;
        first.rightChild = second.rightChild;

        second.leftChild = null;
        second.rightChild = null;
        second.data = null;
    }
}
