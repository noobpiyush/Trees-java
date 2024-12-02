package hard_problems;

import binaryTree1.Node;

import java.util.LinkedList;
import java.util.Queue;

public class ChildrenSumBT {

    public static int childrenSum(Node root){

        if ((root == null) || (root.left == null && root.right == null)) return 1;

        int sum = 0;

        if (root.left != null) sum += root.left.data;

        if (root.right != null) sum += root.right.data;

        return ((root.data == sum)
                && childrenSum(root.left) == 1
                && childrenSum(root.right) == 1 )
                ? 1 : 0;
    }

    public static  int childrenSumIterative(Node root){
        if (root == null) return 1;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()){
            Node cur = q.poll();

            if (cur.left == null && cur.right == null){
                continue;
            }

            int sum = 0;

            if (cur.left != null){
                sum += cur.left.data;
            }

            if (cur.right != null){
                sum+= cur.right.data;
            }

            if (sum != cur.data){
                return 0;
            }

            if (cur.left != null){
                q.add(cur.left);
            }

            if (cur.right != null){
                q.add(cur.right);
            }


        }

        return 1;
    }
}
