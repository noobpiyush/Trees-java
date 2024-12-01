package medium_problems;

import binaryTree1.Node;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBT {

    public List<Integer> leftView(Node root){

        List<Integer> ans = new ArrayList<>();

        if (root == null) return  ans;

        leftViewUtil(root, 0, ans);

        return  ans;

    }
    public void leftViewUtil(Node root, int level, List<Integer> ans){

        if (root == null) return;

        if (level == ans.size()){
            ans.add(root.data);
        }

        leftViewUtil(root.left,level + 1, ans);

        leftViewUtil(root.right, level + 1, ans);

    }


}
