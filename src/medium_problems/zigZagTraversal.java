package medium_problems;

import binaryTree1.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigZagTraversal {

    public static List<List<Integer>> zigZagLevelOrderTraversal(Node root){
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        boolean leftToRight = true;

        while (!q.isEmpty()){
            int size = q.size();

            List<Integer> list = new ArrayList<>();

            for (int i =0;i<size;i++){
                Node node = q.poll();

                list.add(node.data);

                if (node.left != null){
                    q.add(node.left);
                }

                if (node.right != null){
                    q.add(node.right);
                }
            }

            //reverse the list is direction id right to left

            if (!leftToRight){
                reverseList(list);
            }

            ans.add(list);

            leftToRight = !leftToRight;
        }

        return ans;

    }

    private static void reverseList(List<Integer> list) {
        int start = 0, end = list.size() - 1;
        while (start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);



        // Get the zigzag level order traversal
        List<List<Integer>> result = zigZagLevelOrderTraversal(root);

        // Print the result
        printResult(result);
    }
}

