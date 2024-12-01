package medium_problems;

import binaryTree1.Node;

public class heightOfBT {
    
    public static int height(Node root){
        
        if (root == null) return 0;
        
        int lh = height(root.left);
        
        int rh = height(root.right);
        
        return 1 + Math.max(lh, rh);
        
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        System.out.println(height(root));
    }
}
