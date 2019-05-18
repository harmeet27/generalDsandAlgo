import Search.BinarySearch;
import Search.LinearSearch;
import TreeImpl.Tree;
import TreeImpl.Node;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void preorder(Node n){
        System.out.println(n.data);
        if(n.left != null){
            preorder(n.left);
        }
        if(n.right != null){
            preorder(n.right);
        }

    }

    public  static  void postorder(Node n){
        if(n.left != null){
            postorder(n.left);
        }
        if(n.right != null){
            postorder(n.right);
        }
        System.out.println(n.data);
    }

    public  static  void inorder(Node n){
        if(n.left != null){
            inorder(n.left);
        }
        System.out.println(n.data);
        if(n.right != null){
            inorder(n.right);
        }

    }

    public static void main(String... args){
//        Scanner st = new Scanner(System.in);
//        Integer length =  st.nextInt();
//        Integer[] InputArray = new Integer[length];
//        int i = 0;
//        while (i < length){
//            InputArray[i] = st.nextInt();
//            i++;
//
//        }
////        LinearSearch search = new LinearSearch();
//        BinarySearch search1 = new BinarySearch();
//        int Index = search1.searchElement(InputArray, st.nextInt());
//        System.out.println(Index);
//        st.close();
        Tree tr = new Tree(); //root = null;
        tr.add(10);  //10 -->
        tr.add(5);
        tr.add(15);
        tr.add(2);
        tr.add(8);
        tr.add(30);
        tr.search(5);

        System.out.println(tr.search(9));
        Node n = tr.getHead();

//        preorder(n);
//        postorder(n);
        inorder(n);




        Queue q = new LinkedList(); //Iterative
        q.add(n);
        while(!q.isEmpty()){
            Node t =(Node) q.remove();
//            System.out.println(t.data);
            if(t.left != null){
               q.add(t.left);
            }
            if(t.right != null){
                q.add(t.right);
            }

        }
//        System.out.println(n.data); //acccess class level variables



    }
}
