import binaryTree1.Node;
public class SearchInBST {

    public static Node searchInBST(Node root, int key){

        if (root == null) return root;

        while (root != null && root.data != key){
            root =  key < root.data ? root.left : root.right;
        }

        return root;
    }
}
