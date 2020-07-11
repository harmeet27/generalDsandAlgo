package com.preparation.ds.tree.harmeet.tree;

public class Tree {
    Node root ;

    public void add(Integer data){
        if(root==null){
            root = new Node(data,null,null, null);
        }
        else {
            add(data, root);
        }
    }

    private void add(Integer data, Node node){
//        if(node == null){
//            node = new Node(data, null, null);
//        }
        /* node.data > data ? add(data, node.left) : add(data, node.right); */
        if(node.data > data){
            if(node.left==null){
                Node temp = new Node(data, null, null, null);
                node.left=temp;
            }
            else{
                add(data,node.left);
            }
        }
        else if(node.data <= data){
            if(node.right==null){
                Node temp = new Node(data, null, null, null);
                node.right=temp;
            }
            else{
                add(data,node.right);
            }
        }

    }

    public boolean search(Integer data){
        return search(data, this.root);
    }

    private  boolean search(Integer data, Node node){
        if(node == null){
            return false;
        }
        if(node.data == data) {
            return true;
        }
        if(node.data > data){
               return search(data, node.left);
        }
        if(node.data <= data){
            return search(data, node.right);
        }
        return  false;
    }

    public Node getHead(){
        return root;
    }
}
