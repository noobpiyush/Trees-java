package medium_problems;

import binaryTree1.Node;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBt {

    public List<Integer> rightView(Node root){

        List<Integer> ans = new ArrayList<>();

        if (root == null) return  ans;

        rightViewUtil(root, 0, ans);

        return  ans;

    }
    public void rightViewUtil(Node root, int level, List<Integer> ans){

        if (root == null) return;

        if (level == ans.size()){
            ans.add(root.data);

            rightViewUtil(root.right,level + 1, ans);

            rightViewUtil(root.left, level + 1, ans);

        }

    }
}
