package com.preparation.ds.tree.harmeet.tree;

public class Node {

    public Integer data ;
    public Node left;
    public Node right;
    public Integer index;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node(Integer data, Node left, Node right, Integer index) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.index = index;
    }
}
