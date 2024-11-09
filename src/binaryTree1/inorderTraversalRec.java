package binaryTree1;

public class inorderTraversalRec {
    //LEFT ROOT RIGHT
    public static  void inOrder(Node root){
        if (root == null) return;

        inOrder(root.left);

        System.out.println(root.data);

        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(35);

        root.left.right = new Node(432);

        root.right = new Node(56);

        inOrder(root);

    }
}
