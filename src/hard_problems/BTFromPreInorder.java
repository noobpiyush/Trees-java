package hard_problems;

import binaryTree1.Node;

import java.util.HashMap;
import java.util.Map;

public class BTFromPreInorder {

    public Node buildTree(int inorder[], int preorder[]){
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0;i<inorder.length;i++){
            inMap.put(inorder[i], i);
        }

        Node root = buildTree(preorder,0,preorder.length - 1,
                inorder, 0 , inorder.length - 1, inMap);

        return root;
    }

    public Node buildTree( int preorder[], int preStart, int preEnd,
                           int inorder[], int inStart, int inEnd,
                           Map<Integer,Integer> iMap){

        if (preStart > preEnd || inStart > inEnd){
            return  null;
        }

        Node root = new Node(preorder[preStart]);

        // Find the index of the current root
        // value in the inorder traversal

        int inRootIndex = iMap.get(root.data);

        int numsLeft = inRootIndex - inStart;

        root.left = buildTree(preorder, preStart + 1,
                preStart +  numsLeft, inorder, inStart,
                inRootIndex - 1, iMap );
        root.right = buildTree(preorder, preStart + numsLeft + 1,
                preEnd, inorder, inRootIndex  + 1,
                inEnd, iMap );

        return root;
    }
}
