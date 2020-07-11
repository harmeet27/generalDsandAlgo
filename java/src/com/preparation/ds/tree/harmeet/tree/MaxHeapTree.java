package com.preparation.ds.tree.harmeet.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxHeapTree {
    static  Node root;

    public  void add(Integer data){
        if (root == null){
            root = new Node(data, null , null, null);
        } else {
            add(data, root);
        }
    }

    public static void add(Integer data, Node node){
        Queue<Node> q  = new LinkedList();
        Stack<Node> st = new Stack();
        q.add(node);
        while(!q.isEmpty()){
            Node pop;
            pop = q.poll();
            st.add(pop);
            if(pop.left == null) {
                pop.left = new Node(data, null, null, null);
                if(pop.data < data){
                    heapifyUp( pop.left, root, st);
                }
                break;
            } else if (pop.right == null){
                pop.right = new Node(data, null, null, null);
                if(pop.data < data){
                    heapifyUp( pop.right, root, st);
                }
                break;
            } else if (pop.left != null && pop.right != null){
                q.add(pop.left);
                q.add(pop.right);
            }
        }

    }

    public static Node heapifyUp(Node node, Node root, Stack st){
        if(!st.isEmpty()) {
            Node parent = (Node) st.pop();
            if (parent.left == node || parent.right == node) {
                if (parent.data < node.data) {
                    int temp = parent.data;
                    parent.data = node.data;
                    node.data = temp;
                    heapifyUp(parent, root, st);
                }
                heapifyUp(node, root, st);
            } else {
                heapifyUp(node, root, st);
            }
        }
        return root;
    }

    public Node getHead() {
        return root;
    }

    public void levelOrder() {
        if (root != null) {
            Queue<Node> queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node pop = queue.poll();
                System.out.println(pop.data);

                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
        }
    }
}
