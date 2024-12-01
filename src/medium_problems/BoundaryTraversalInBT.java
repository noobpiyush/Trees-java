package medium_problems;

import binaryTree1.Node;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversalInBT {

    public  static  boolean isLeaf(Node root){
        if (root.left == null && root.right == null) {
            return true;
        }
        return  false;
    }

    public static void AddLeftBoundaryTraversal(Node root, List<Integer> ans){

        if (root == null) return;

        Node cur = root.left;

        while (cur != null){
            if (!isLeaf(cur)){
                ans.add(cur.data);
            }

            if (cur.left != null){
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
        }
    }
    public static void AddRightBoundaryTraversal(Node root, List<Integer> ans){

        List<Integer> temp = new ArrayList<>(); // Temporary list to store right boundary
        Node cur = root.right;
        while (cur != null) {
            if (!isLeaf(cur)) {
                temp.add(cur.data); // Add only non-leaf nodes
            }
            if (cur.right != null) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        // Add the right boundary in reverse order
        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }

    }

    //preorder traversal to add leaf

    public static void addLeaves(Node root, List<Integer> ans){

        if (isLeaf(root)){
            ans.add(root.data);
        }

       if (root.left != null){
           addLeaves(root.left,ans);
       }
       if (root.right != null){
           addLeaves(root.right,ans);
       }
    }

    public  static  List<Integer> boundaryTraversal (Node root){
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        if (!isLeaf(root)){
            ans.add(root.data);
        }

        AddLeftBoundaryTraversal(root,ans);
        addLeaves(root,ans);
        AddRightBoundaryTraversal(root,ans);

        return ans;
    }
}
