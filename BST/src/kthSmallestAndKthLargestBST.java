import binaryTree1.Node;

import java.util.Queue;
import java.util.Stack;

public class kthSmallestAndKthLargestBST {

    public static int kthSmallest(Node root, int k){
        Stack<Node> st = new Stack<>();
        Node cur = root;
        int cnt = 0;

        while(!st.isEmpty() || cur != null){

            while (cur != null){
                st.push(cur);
                cur = cur.left;
            }

            cur = st.pop();
            cnt++;
            if (cnt == k) return cur.data;
            cur = cur.right;
        }

        return -1;
    }

    public static int kthLargest(Node root, int k){
        Stack<Node> st = new Stack<>();
        int cnt = 0;
        Node cur = root;

        while (!st.isEmpty() || cur != null){
            while (cur != null){
                st.push(cur);
                cur = cur.right; //the kth largest will be on the right
            }

            cur = st.pop();
            cnt++;
            if (cnt == k) return cur.data;
            cur = cur.left;
        }

        return -1;
    }
}
