package TreeImpl;

public class Node {

    public Integer data ;
    public Node left;
    public Node right;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node(Integer data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
