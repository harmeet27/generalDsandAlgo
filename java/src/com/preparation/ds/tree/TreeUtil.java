package com.preparation.ds.tree;

import com.preparation.ds.tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    public static LinkedList preOrder(BinaryTreeNode root) {
        if (root == null) {
            throw new RuntimeException("Empty tree pre order traversal");
        }
        LinkedList rootList = new LinkedList<>();
        rootList.add(root.data);
        if (root.leftChild != null)
            rootList.addAll(preOrder(root.leftChild));
        if (root.rightChild != null)
            rootList.addAll(preOrder(root.rightChild));
        return rootList;
    }

    public static LinkedList postOrder(BinaryTreeNode root) {
        if (root == null) {
            throw new RuntimeException("postOrder traversal performed on empty tree");
        }
        LinkedList postOrderTraversal = new LinkedList();
        if (root.leftChild != null)
            postOrderTraversal.addAll(postOrder(root.leftChild));
        if (root.rightChild != null)
            postOrderTraversal.addAll(postOrder(root.rightChild));

        postOrderTraversal.add(root.data);
        return postOrderTraversal;
    }

    public static LinkedList inOrder(BinaryTreeNode root) {
        if (root == null) {
            throw new RuntimeException("Inorder Traversal performed on empty tree");
        }

        LinkedList inOrderTraversal = new LinkedList();

        if (root.leftChild != null)
            inOrderTraversal.addAll(inOrder(root.leftChild));

        inOrderTraversal.add(root.data);

        if (root.rightChild != null) {
            inOrderTraversal.addAll(inOrder(root.rightChild));
        }

        return inOrderTraversal;
    }

    public static LinkedList levelOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            throw new RuntimeException("Level order performed on empty tree");
        }
        LinkedList levelOrder = new LinkedList<>();
        Queue<BinaryTreeNode> traversal = new LinkedList<>();
        traversal.add(root);
        while (!traversal.isEmpty()) {
            BinaryTreeNode poppedElement = traversal.poll();
            levelOrder.add(poppedElement.data);

            if (poppedElement.leftChild != null)
                traversal.add(poppedElement.leftChild);
            if (poppedElement.rightChild != null)
                traversal.add(poppedElement.rightChild);
        }

        return levelOrder;
    }

}
