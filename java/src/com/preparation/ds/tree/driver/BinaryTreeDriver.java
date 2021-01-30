package com.preparation.ds.tree.driver;

import com.preparation.ds.tree.TreeUtil;
import com.preparation.ds.tree.impl.BinaryTreeImpl;

import java.util.LinkedList;

public class BinaryTreeDriver {

    public static void main(String... s) {
        BinaryTreeImpl<String> binaryTreeImpl = new BinaryTreeImpl<>();
        binaryTreeImpl.add("A");
        binaryTreeImpl.add("B");
        binaryTreeImpl.add("C");
        binaryTreeImpl.add("D");
        binaryTreeImpl.add("E");
        binaryTreeImpl.add("F");
        binaryTreeImpl.add("G");
        binaryTreeImpl.add("H");
        binaryTreeImpl.add("I");
        binaryTreeImpl.add("J");
        LinkedList<String> preOrder = TreeUtil.preOrder(binaryTreeImpl.getRoot());
        System.out.println("preorder traversal");
        preOrder.stream().forEach(order -> System.out.print(order + ", "));
        System.out.println();
        System.out.println("Level order Traversal");
        TreeUtil.levelOrderTraversal(binaryTreeImpl.getRoot()).stream().forEach(order -> System.out.print(order + ", "));
        System.out.println();
        System.out.println("In order Traversal");
        TreeUtil.inOrder(binaryTreeImpl.getRoot()).stream().forEach(order -> System.out.print(order + ", "));
        System.out.println();
        System.out.println("Post order Traversal");
        TreeUtil.postOrder(binaryTreeImpl.getRoot()).stream().forEach(order -> System.out.print(order + ", "));

        System.out.println();
        System.out.println("Search K");
        System.out.println(binaryTreeImpl.search("J"));
    }
}
