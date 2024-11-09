package binaryTree1;

public class postOrderTraversalRec {
    //LEFT RIGHT ROOT
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(35);

        root.left.right = new Node(432);

        root.right = new Node(56);

        postOrder(root);
    }
}
