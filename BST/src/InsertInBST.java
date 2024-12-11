import binaryTree1.Node;
public class InsertInBST {

    public static Node insert(Node root, int val){
        if (root == null) return new Node(val);

        Node cur = root;

        while (true){

            //if the val should be on right
            if(cur.data <= val){

                if (cur.right != null) cur = cur.right;
                else {
                    cur.right = new Node(val);
                    break;
                }
            }
            else {
                //if val should be on left
                if (cur.left != null) cur = cur.left;
                else {
                    cur.left = new Node(val);
                    break;
                }
            }
        }

        return root;
    }
}
