package hard_problems;

import binaryTree1.Node;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SearlizeNDeserialzeBT {

    public String serialize(Node root){
        if (root == null) return "";

        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.add(root);

        while (!q.isEmpty()){
            Node cur = q.poll();

            if (cur == null){
                res.append("n ");
                continue;
            }
            res.append(cur.data + " ");
            q.add(cur.left);
            q.add(cur.right);
        }

        return res.toString();
    }

    public Node deserialize(String data){
        if (Objects.equals(data, "")) return null;

        Queue<Node> q = new LinkedList<>();

        String[] values = data.split(" ");

        Node root = new Node(Integer.parseInt(values[0]));

        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < values.length) {
            Node parent = q.poll();

            // Process left child
            if (!values[i].equals("n")) {
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            i++; // Increment index after processing the left child

            // Process right child
            if (i < values.length && !values[i].equals("n")) {
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
            i++; // Increment index after processing the right child
        }

        return root;
    }
}
