package StorageEngineComponents.MemtableComponents.L2Memtable;

import StorageEngineComponents.Utilities.Node;
import StorageEngineComponents.Utilities.Tuple;

import java.util.Objects;

class BST extends L2SearchTable {


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
    public Tuple<?, ?> Search(Float key) {
        Node node = RecursiveSearch(root, key);

        if (node == null){
            return null;
        }

        return node.val;
    }

    @Override
    public void Insert(Tuple<Float, Object> val) {

        if (root == null){
            root = new Node(null, null, val);
            return;
        }

        Node parent = null;
        Node ptr = root;
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

    //Complete BST Delete
    @Override
    public void Delete(Float key) {
        Node prev = null;
        Node curr = root;

        if (root == null){
            return;
        }

        if(root.val.key == key){
            if(root.left == null && root.right != null){
                root = root.right;
            }
            else if(root.left != null && root.right == null){
                root = root.left;
            }
            else{
             //find in order successor
             //set in order successor as the new root
            }
        }


        while(curr != null){
            if(curr.val.key > key){
                prev = curr;
                curr = curr.right;
            }
            else if(curr.val.key < key){
                prev = curr;
                curr = curr.left;
            }
            else{
                break;
            }
        }

        //curr wasn't found
        if(curr == null){
            return;
        }
        else{
            if(curr.left == null && curr.right == null){

            }
        }
    }

    private void InOrderTraversal(Node node){
        if (node == null){
            return;
        }

        InOrderTraversal(node.left);
        //Needs to be removed
        System.out.print(node.val.key + " ");
        InOrderTraversal(node.right);
    }

    public void OutputEntries(){
        InOrderTraversal(root);
    }
}

