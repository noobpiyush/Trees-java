package binaryTree1;

public class preOrderTraversalRec {
    //preorder = ROOT,LEFT, RIGHT
    public static void  preOrder(Node root){
        if (root == null) return;

        System.out.println(root.data);

        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(35);

        root.left.right = new Node(432);

        root.right = new Node(56);


        preOrder(root);
    }
}
