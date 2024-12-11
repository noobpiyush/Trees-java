import binaryTree1.Node;

public class FloorInBST {

    public  static int Floor(Node root, int val){

        if (root == null) return -1;

        int floor = -1;

        while (root != null){

            if (root.data == val){
                floor = root.data;
                return floor;
            }
            if (root.data < val){
                floor =root.data;
                root = root.right;
            }else {
                root = root.left;
            }
        }

        return floor;
    }
}
