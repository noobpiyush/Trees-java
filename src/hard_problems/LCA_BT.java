package hard_problems;

import binaryTree1.Node;

import java.util.ArrayList;
import java.util.List;

public class LCA_BT {

    public static Node LCA(Node root, Node p, Node q) {
        if (root == null || root == p || root == q){
            return root;
        }

        Node left = LCA(root.left,p,q);

        Node right = LCA(root.right,p,q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    public static int LCABrute(Node root, Node p, Node q) {
        if (root == null) return -1;

        // Lists to store the paths from root to p and q
        List<Integer> pPath = new ArrayList<>();
        List<Integer> qPath = new ArrayList<>();

        // Find paths for both p and q
        findPath(root, p, new ArrayList<>(), pPath);
        findPath(root, q, new ArrayList<>(), qPath);

        int i = 0; // Index to traverse both paths
        int lca = -1; // Variable to store the LCA

        // Compare the paths to find the last common node
        while (i < pPath.size() && i < qPath.size() && pPath.get(i).equals(qPath.get(i))) {
            lca = pPath.get(i); // Update LCA
            i++;
        }

        return lca;
    }

    public static boolean findPath(Node root, Node target, List<Integer> currentPath, List<Integer> resultPath) {
        if (root == null) return false;

        // Add the current node to the path
        currentPath.add(root.data);

        // If the target node is found, copy the path to the result
        if (root.data == target.data) {
            resultPath.addAll(currentPath);
            return true;
        }

        // Recursively check left and right subtrees
        if (findPath(root.left, target, currentPath, resultPath) || findPath(root.right, target, currentPath, resultPath)) {
            return true;
        }

        // If the target is not found, backtrack
        currentPath.remove(currentPath.size() - 1);
        return false;
    }

}
