package hard_problems;

import binaryTree1.Node;

public class FlattenBT2LL {

    static  Node prev = null;

    public static  void flattenBrute(Node root){
        if (root == null) return;

        flattenBrute(root.right);
        flattenBrute(root.left);

        root.right = prev;

        root.left = null;

        prev = root;
    }

    public static void flatten(Node root){
        Node cur = root;

        while (cur != null){

            if (cur.left != null){
                Node prev = cur.left;

                while (prev.right != null){
                    prev = prev.right;
                }
                // Connect the rightmost node in
                // the left subtree to the current
                // node's right child
                prev.right = cur.right;

                // Move the entire left subtree to the
                // right child of the curent node
                cur.right = cur.left;

                // Set the left child of
                // the curent node to NULL
                cur.left = null;
            }

            // Move to the next node
            // on the right side
            cur = cur.right;
        }
    }
}
