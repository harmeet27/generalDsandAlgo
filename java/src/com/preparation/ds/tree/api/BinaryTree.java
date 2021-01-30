package com.preparation.ds.tree.api;

import com.preparation.ds.tree.model.BinaryTreeNode;

public interface BinaryTree<E> {

    void add(E data);

    boolean search(E data);

    BinaryTreeNode<E> delete(E data);

    BinaryTreeNode<E> getRoot();

}
