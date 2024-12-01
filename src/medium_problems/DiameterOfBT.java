package medium_problems;

import binaryTree1.Node;

public class DiameterOfBT {

     int diameter = 0;

    public int diameterBT(Node root){

        diameterUtilBrute(root);

        return diameter;
    }

    public int diameterOfBinaryTreeOptimal(Node root){
        int[] diameter = new int[1];

        diameter[0] = 0;

        diameterUtilOptimal(root, diameter);

        return diameter[0];
    }



    public int diameterUtilOptimal(Node root, int diameter[]){

        if(root == null){
            return  0;
        }

        int lh[] = new int[1];

        int rh[] =  new int[1];

        lh[0] = diameterUtilOptimal(root.left,diameter);

        rh[0] = diameterUtilOptimal(root.right,diameter);

        diameter[0] = Math.max(lh[0] + rh[0], diameter[0]);

        return 1 + Math.max(lh[0],rh[0]);

    }
    public int diameterUtilBrute(Node root){

        if(root == null){
            return  0;
        }

        int lh = diameterUtilBrute(root.left);

        int rh = diameterUtilBrute(root.right);

        diameter = Math.max(lh + rh, diameter);

        return 1 + Math.max(lh,rh) + 1;

    }


}
