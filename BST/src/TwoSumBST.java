import binaryTree1.Node;

import java.util.Stack;

class BSTIterators {
    Stack<Node> st = new Stack<>();
    Boolean reverse;

    public BSTIterators(Node root, boolean isReverse) {
        reverse = isReverse;
        insertAll(root);
    }

    public int next() {
        Node temp = st.pop();
        if (reverse == false) {
            insertAll(temp.right);
        } else {
            insertAll(temp.left);
        }
        return temp.data;

    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void insertAll(Node root) {
        while (root != null) {
            st.push(root);
            if (reverse == true) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

}
public  class TwoSumBST {
    public boolean findTarget(Node root, int k) {
        if (root == null) return false;
        BSTIterators lt = new BSTIterators(root, false);
        BSTIterators rt = new BSTIterators(root, true);
        int i = lt.next();
        int j = rt.next();
        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j < k) {
                i = lt.next();
            } else {
                j = rt.next();
            }
        }
        return false;
    }
}