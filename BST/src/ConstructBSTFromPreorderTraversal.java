import binaryTree1.Node;

public class ConstructBSTFromPreorderTraversal {

    public static Node BST(int preorder[]){
        return BSTUtil(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    public static Node BSTUtil(int preorder[], int bound, int [] i){
        if (i[0] >= preorder.length || preorder[i[0]] > bound) return null;

        Node root = new Node(preorder[i[0]++]);

        root.left = BSTUtil(preorder, root.data,i);

        root.right = BSTUtil(preorder, bound,i);

        return root;
    }


}
