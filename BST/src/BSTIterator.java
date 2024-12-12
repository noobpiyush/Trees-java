import binaryTree1.Node;

import java.util.Stack;

public class BSTIterator {
    private Stack<Node > st = new Stack<>();

    public BSTIterator(Node root) {
        pushAll(root);
    }

    public int next() {

        if (st.isEmpty()) return -1;

        Node temp = st.pop();
        pushAll(temp.right);
        return temp.data;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAll(Node root){
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
}
