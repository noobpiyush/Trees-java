import binaryTree1.Node;

public class DeleteNodeInBST {

    public static Node delete(Node root, int val){

        if (root == null) return root;

        if (root.data == val){
            return deleteUtil(root);
        }

        Node cur = root;

        while (cur != null){

            if (cur.data > val){
                if (cur.left != null && cur.left.data == val){
                    cur.left = deleteUtil(cur.left);
                    break;
                }else {
                    cur =  cur.left;
                }
            }
            else {
                if (cur.right != null && cur.right.data == val){
                    cur.right = deleteUtil(cur.right);
                    break;
                }
                else cur = cur.right;
            }
        }
        return root;
    }

    public static Node deleteUtil(Node root){
        if (root.left == null) return root.right;
        else if (root.right == null) {
            return root.left;
        }
        else {
            Node rightChild = root.right;
            Node lastRightChild = findRight(root.left);
            lastRightChild.right = rightChild;
            return root.left;
        }
    }

    public static Node findRight(Node root){
        if (root.right == null){
            return  root;
        }
        return  findRight(root.right);
    }
}
