package com.preparation.ds.tree.model;

public class BinaryTreeNode<E> {
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;
    public E data;

    public BinaryTreeNode(E data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }

    public BinaryTreeNode(BinaryTreeNode leftChild, BinaryTreeNode rightChild, E data) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    @Override
    public int hashCode() {
        return leftChild.hashCode() + rightChild.hashCode() + data.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        BinaryTreeNode comparisonNode = (BinaryTreeNode) obj;
        return comparisonNode.leftChild.equals(this.leftChild) && comparisonNode.rightChild.equals(this.rightChild) &&
                comparisonNode.data.equals(this.data);
    }

    @Override
    public String toString() {
        return String.format("{ leftChild: %s " +
                ", rightChild: %s ," +
                " data: %s }", leftChild, rightChild, data);
    }

}
