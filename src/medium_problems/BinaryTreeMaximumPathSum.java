package medium_problems;

import binaryTree1.Node;

public class BinaryTreeMaximumPathSum {

    public int maxPathSum(Node root){
        int maxi[] = {Integer.MIN_VALUE};

        maxPathSumUtil(root, maxi);

        return maxi[0];
    }

    public int maxPathSumUtil(Node root, int maxi[]){
        if (root == null){
            return  0;
        }

        int lh = Math.max(0, maxPathSumUtil(root.left,maxi));
        int rh = Math.max(0, maxPathSumUtil(root.right,maxi));

        //update maxi

        maxi[0] = Math.max(maxi[0], lh + rh + root.data);

        return Math.max(lh, rh) + root.data;
    }
}
