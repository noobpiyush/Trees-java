package hard_problems;

import binaryTree1.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BurnBinaryTree {

    // BFS to map parent nodes and find the target node
    public static Node mapParents(Node root, Map<Node, Node> parentMap, Node start) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node target = null;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.data == start.data) {
                target = cur;
            }

            if (cur.left != null) {
                parentMap.put(cur.left, cur);
                q.add(cur.left);
            }

            if (cur.right != null) {
                parentMap.put(cur.right, cur);
                q.add(cur.right);
            }
        }

        return target;
    }

    // BFS to calculate the maximum time to burn the tree
    public static int findMaxDistance(Node start, Map<Node, Node> parentMap) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        Map<Node, Boolean> visited = new HashMap<>();
        visited.put(start, true);
        int maxDistance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                // Check left child
                if (cur.left != null && visited.get(cur.left) == null) {
                    flag = true;
                    visited.put(cur.left, true);
                    q.add(cur.left);
                }

                // Check right child
                if (cur.right != null && visited.get(cur.right) == null) {
                    flag = true;
                    visited.put(cur.right, true);
                    q.add(cur.right);
                }

                // Check parent
                if (parentMap.containsKey(cur) && visited.get(parentMap.get(cur)) == null) {
                    flag = true;
                    visited.put(parentMap.get(cur), true);
                    q.add(parentMap.get(cur));
                }
            }

            if (flag) maxDistance++;
        }

        return maxDistance;
    }

    // Main function to calculate the time to burn the tree
    public static int timeToBurnTree(Node root, Node start) {
        Map<Node, Node> parentMap = new HashMap<>();
        Node target = mapParents(root, parentMap, start);
        return findMaxDistance(target, parentMap);
    }

    // Example usage
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node start = root.left.left; // Node with value 4
        System.out.println("Time to burn the tree: " + timeToBurnTree(root, start));
    }
}
