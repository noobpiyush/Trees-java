package binaryTree1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(Node root){

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null){
            //return empty list
            return ans;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i =0;i<size;i++){
                Node node = q.poll();

                if (node!= null) {

                    list.add(node.data);

                    if (node.left != null){
                        q.add(node.left);
                    }

                    if (node.right != null){
                        q.add(node.right);
                    }
                }
            }

            ans.add(list);
        }

        return ans;
    }

    static void printList(List<Integer> list) {
        // Iterate through the
        // list and print each element
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<List<Integer>> result =levelOrder(root);

        System.out.println("Level Order Traversal of Tree:");

        // Printing the level order traversal result
        for (List<Integer> level : result) {
            printList(level);
        }

    }
}
