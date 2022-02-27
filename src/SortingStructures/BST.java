package SortingStructures;

import Utilities.Node;
import Utilities.Tuple;

public class BST extends Memtable {

    private Node RecursiveSearch(Node node, Float key){

        if (node == null){
            return null;
        }

        if (node.val.key.equals(key)){
            return node;
        }
        else if(node.val.key > key){
            return RecursiveSearch(node.left, key);
        }
        else{
            return RecursiveSearch(node.right, key);
        }

    }

    @Override
    public Node Search(Float key) {
        return RecursiveSearch(node, key);
    }

    @Override
    public void Insert(Tuple<Float, Object> val) {

        if (node == null){
            node = new Node(null, null, val);
            return;
        }

        Node parent = null;
        Node ptr = node;
        while (ptr != null){
            parent = ptr;
            if (ptr.val.key.equals(val.key)){
                ptr.val = val;
                return;
            }
            else if (ptr.val.key > val.key){
                ptr = ptr.left;
            }
            else{
                ptr = ptr.right;
            }
        }

        Node child = new Node(null, null, val);

        if(parent.val.key > val.key){
            parent.left = child;
        }
        else{
            parent.right = child;
        }

    }

    @Override
    public void Delete(Float key) {
        Node ptr = Search(key);

    }


    public void InOrderTraversal(Node node){
        if (node == null){
            return;
        }

        InOrderTraversal(node.left);
        System.out.print(node.val.key + " ");
        InOrderTraversal(node.right);
    }

    public void OutputNodes(){
        InOrderTraversal(node);
    }
}

