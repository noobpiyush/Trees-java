import binaryTree1.Node;

public class LCAInBST {

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) return null;
        int cur = root.data;
        if (cur < p.data && cur < q.data){
            return  lowestCommonAncestor(root.right,p,q);
        }
        if (cur > p.data && cur > q.data){
            return lowestCommonAncestor(root.left,p,q);
        }

        return root;
    }
}
