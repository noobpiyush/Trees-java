import binaryTree1.Node;

public class inorderSuccessorNPredecessorBST {

    public static Node inorderSuccessor(Node root, int key) {
        Node successor = null;

        while (root != null) {
            if (key < root.data) { // Successor is in the left subtree
                successor = root;
                root = root.left;
            } else { // Continue searching in the right subtree
                root = root.right;
            }
        }

        return successor;
    }

    public static Node inorderPredecessor(Node root, int key) {
        Node predecessor = null;

        while (root != null) {
            if (key > root.data) { // Predecessor is in the right subtree
                predecessor = root;
                root = root.right;
            } else { // Continue searching in the left subtree
                root = root.left;
            }
        }

        return predecessor;
    }
}
