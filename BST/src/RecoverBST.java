import binaryTree1.Node;

public class RecoverBST {

    static Node prev=null,first=null,second=null;

    public  static void   inorder(Node root){
        if(root==null)
            return ;
        inorder(root.left);
        if(prev!=null&&root.data<prev.data){
            if(first==null)
                first=prev;
            second=root;
        }
        prev=root;
        inorder(root.right);
    }

    public static void recoverTree(Node root) {
        if(root==null)
            return ;
        inorder(root);
        int temp=first.data;
        first.data=second.data;
        second.data=temp;
    }
}
