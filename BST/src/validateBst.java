import binaryTree1.Node;

public class validateBst {

    public static boolean isValid(Node root){
        if (root == null) return true;

        return isValidUtil(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }

    public static boolean isValidUtil(Node root,long min, long max){

        if (root == null)return true;

        if (root.data >= max || root.data <= min) return false;

        return isValidUtil(root.left,min,root.data) && isValidUtil(root.right,root.data,max);
    }
}
