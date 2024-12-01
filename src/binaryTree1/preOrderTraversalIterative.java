package binaryTree1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preOrderTraversalIterative {

    public static ArrayList<Integer> preOrder(Node root){

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        Stack<Node> st = new Stack<>();

        st.push(root);

        while (!st.isEmpty()){

            root = st.pop();

            ans.add(root.data);

            if (root.right != null){
                st.push(root.right);
            }

            if (root.left != null){
                st.push(root.left);
            }
        }
        return  ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> result =preOrder(root);

        System.out.println("Level Order Traversal of Tree:");

        // Printing the level order traversal result
        for (int level : result) {
            System.out.println(level);
        }
    }
}
