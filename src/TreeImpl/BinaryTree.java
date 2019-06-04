package TreeImpl;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public void add(Integer data) {
        if (root == null) {
            root = new Node(data, null, null, null);
        } else {
            add(data, root);
        }
    }

    private static void add(Integer data, Node root) {
        Queue<Node> q  = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            Node pop;
            pop = q.poll();
            if(pop.left == null) {
                pop.left = new Node(data, null, null, null);
                break;
            } else if (pop.right == null){
                pop.right = new Node(data, null, null, null);
                break;
            } else if (pop.left != null && pop.right != null){
                q.add(pop.left);
                q.add(pop.right);
            }
        }

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
