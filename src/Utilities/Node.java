package Utilities;

public class Node {

    public Node left;
    public Node right;
    public Tuple<Float, Object> val;

    public Node(Node left, Node right, Tuple<Float, Object> val){
        this.left = left;
        this.right = right;
        this.val = val;
    }

}
