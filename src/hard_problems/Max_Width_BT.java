package hard_problems;

import binaryTree1.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Max_Width_BT {

    static class Pair {
        Node root;
        int num;

        Pair(Node root, int num){
            this.root = root;
            this.num = num;
        }
    }


    public int MaxWidth(Node root){
        if (root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));

        while (!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num;
            int first =0,last = 0;

            for (int i =0;i<size;i++){
                int cur_id = q.peek().num - mmin;
                Node node = q.peek().root;
                q.poll();
                if (i == 0) first = cur_id;
                if (i == size - 1) last = cur_id;
            }
        }
    }
}
