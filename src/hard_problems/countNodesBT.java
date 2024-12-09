package hard_problems;

import binaryTree1.Node;

public class countNodesBT {

    public static int count(Node root){

        if (root == null) return 0;

        int lh = leftHeight(root);

        int rh = rightHeight(root);

        if (lh == rh){
            return ((2<<(lh)) - 1);
        }
        else{
            return count(root.left) + count(root.right) + 1;
        }
    }

    public static int leftHeight(Node root){
        int count = 0;

        while (root.left != null){
            count++;
            root = root.left;
        }

        return count;
    }
    public static int rightHeight(Node root){
        int count = 0;

        while (root.right != null){
            count++;
            root = root.right;
        }

        return count;
    }
}
