package hard_problems;

import binaryTree1.Node;

import java.util.HashMap;
import java.util.Map;

public class BTFromPostInorder {

    public static Node buildTree(int inorder[], int postorder[]){
        if (inorder.length != postorder.length) return null;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0;i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        Node root = buildTree(inorder,0,inorder.length -1,postorder, 0 , postorder.length -1, map);

        return root;
    }

    private static Node buildTree(int inorder[], int is, int ie,
                                  int postorder[], int ps, int pe, Map<Integer, Integer> iMap){

        if (ps > pe || is > ie) return null;

        Node root = new Node(postorder[pe]);

        int inRoot = iMap.get(root.data);

        int numsLeft = inRoot - is;

        root.left = buildTree(inorder,is,inRoot - 1,
                postorder,ps, ps + numsLeft - 1,iMap);

        root.right = buildTree(inorder, inRoot + 1, ie,
                postorder, ps + numsLeft, pe - 1,iMap);

        return root;
    }
}
