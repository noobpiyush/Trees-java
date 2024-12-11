import binaryTree1.Node;

public class CielinBST {

    public static int ciel(Node root, int val){

        if (root == null) return -1;

        int ciel = -1;

        while (root != null){

            if (root.data == val){
                ciel = root.data;
                return ciel;
            }
            if (root.data > val){
                ciel = root.data;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        return ciel;
    }

}
