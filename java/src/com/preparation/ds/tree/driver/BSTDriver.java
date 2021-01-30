package com.preparation.ds.tree.driver;

import com.preparation.ds.tree.TreeUtil;
import com.preparation.ds.tree.impl.BST;
import com.preparation.ds.tree.model.BinaryTreeNode;

import java.util.Comparator;

public class BSTDriver {

    static class NodeComparator implements Comparator<BinaryTreeNode<String>> {

        @Override
        public int compare(BinaryTreeNode<String> o1, BinaryTreeNode<String> o2) {
            return o1.data.compareTo(o2.data);
        }
    }


    public static void main(String... s) {


//        BST<String> bst = new BST(new NodeComparator());
//
//        bst.add("50");
//        bst.add("30");
//        bst.add("40");
//        bst.add("60");

        BST<Integer> bst = new BST();
        bst.add(50);
        bst.add(30);
        bst.add(40);
        bst.add(60);

        TreeUtil.inOrder(bst.getRoot()).stream().forEach(order -> System.out.print(order + ","));

        System.out.println();
        System.out.println(bst.search(10));
        System.out.println(bst.search(30));
        System.out.println(bst.search(40));
        System.out.println(bst.search(70));
    }
}
