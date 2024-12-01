package medium_problems;

import binaryTree1.Node;

public class check_for_balanced_bt {

    public boolean isBalanced(Node root) {

        if(root == null ) return true;

        return isBalancedUtil(root) != -1;

    }


    public int isBalancedUtil(Node root) {

        if(root == null ) return 0;

        int lh = isBalancedUtil(root.left);

        if(lh == -1) return -1;

        int rh = isBalancedUtil(root.right);

        if(rh == -1) return -1;

        int diff = Math.abs(lh - rh);

        if(diff > 1) return -1;

        return Math.max(lh, rh) + 1;


    }
    public boolean isBalancedUtilBrute(Node root) {

        if (root == null){
            return true;
        }

        //calculate the height of left and right  subtree

        int leftHeight = heightOfBT.height(root.left);

        int rightHeight = heightOfBT.height(root.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalancedUtilBrute(root.left) && isBalancedUtilBrute(root.right)){
            return true;
        }

        return false;
    }
}
