import Search.BinarySearch;
import Search.LinearSearch;
import TreeImpl.BinaryTree;
import TreeImpl.Tree;
import TreeImpl.Node;

import java.util.*;

public class Main {

    public static void leftView(Node n){
        Queue q = new LinkedList();
        q.add(n);
        q.add('$');
        System.out.println(n.data);
        while(!q.isEmpty()){
            char t = 'x';
            if(q.peek().equals('$')){
                 t = (char) q.remove();

            }
            if(!q.peek().equals('$')) {
                Node node = (Node) q.remove();
                if(t =='$') {
                    System.out.println(node.data);
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                if(q.peek().equals('$')){
                    q.add('$');

                }
            } else {
                q.remove();
            }

        }

    }

    static HashMap map = new HashMap();

    public static  void topView(Node n){
        if(!map.containsKey(n.index)){
            System.out.println(n.data);
            map.put(n.index, true);
        }
        if(n.left != null){
            n.left.index = n.index - 1;
            topView(n.left);
        }
        if(n.right != null){
            n.right.index = n.index + 1;
            topView(n.right);
        }

    }

    public static void preorder(Node n){
//        System.out.println(n.data);
//        if(n.left != null){
//            preorder(n.left);
//        }
//        if(n.right != null){
//            preorder(n.right);
//        }
//       Queue<Node> q = new LinkedList();
        Stack<Node> st = new Stack();
       st.add(n);
       while(!st.isEmpty()){
            Node no =  st.pop();
           System.out.println(no.data);
           if(no.right != null){
               st.push(no.right);
           }
           if(no.left != null){
               st.push(no.left);
           }
       }
    }

    public  static  void postorder(Node n){
//        if(n.left != null){
//            postorder(n.left);
//        }
//        if(n.right != null){
//            postorder(n.right);
//        }
//        System.out.println(n.data);
        Stack<Node> st = new Stack();  // 10 , 15
        Stack <Node> In = new Stack();  // 10 5 2 8 15 30
        st.add(n);
        while(!st.isEmpty()){
            Node peek = st.peek();
            if(In.search(peek) != -1){
                System.out.println(st.pop().data);
                continue;
            }
            if(peek.right != null || peek.left != null ){
                In.push(peek);
                if(peek.right != null) {
                    st.push(peek.right);
                }
                if(peek.left != null ) {
                    st.push(peek.left);
                }
            }

            if(peek.left == null && peek.right == null  ){
                if(In.search(peek) == -1) {
                    In.push(peek);
                }
                if(In.search(st.peek()) != -1){
                    System.out.println(st.pop().data);
                }
            }


        }
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

    public static  int heightOfTree(Node n){
        int l = 0;
        int r = 0;
        if(n.left != null){
            l =  heightOfTree(n.left);
        }
        if(n.right != null){
           r =  heightOfTree(n.right);
        }
        if(n.left == null && n.right == null){
            return 1;
        }
        if(l > r ){
            return l + 1;
        } else {
            return r + 1;
        }

    }

    public static int getHeight(Node root){
        if (root == null){
            return -1;
        }
        else{
            return 1 + Math.max( getHeight(root.left), getHeight(root.right) );
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
        tr.add(10);  //10 --> 5, 2,   10, 5 ,2, 8, 15 , 30,   2 8 5 30 15 10
        tr.add(5);
        tr.add(15);
        tr.add(2);
        tr.add(8);
        tr.add(30);
        tr.add(31);
        tr.search(5);

//        System.out.println(tr.search(9));
        Node n = tr.getHead();

//        preorder(n);
//        postorder(n);
//        inorder(n);
//          System.out.println(getHeight(n));

//          leftView(n);
//            n.index = 0;   //topView
//            topView(n);

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

        BinaryTree trBT = new BinaryTree(); //root = null;
        trBT.add(10);  //10 --> 5, 2,   10, 5 ,2, 3, 8, 15 , 30 31,   2 8 5 30 15 10
        trBT.add(15);
        trBT.add(25);
        trBT.add(35);
        trBT.add(1);
        trBT.add(45);
        trBT.add(55);
        trBT.add(75);
        trBT.add(85);
        trBT.add(95);
        trBT.add(65);
        trBT.add(105);
        trBT.add(205);
        trBT.add(305);
        preorder(trBT.getHead());


//        trBT.levelOrder();



    }
}
