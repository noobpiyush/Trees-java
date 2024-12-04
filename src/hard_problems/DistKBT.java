package hard_problems;

import binaryTree1.Node;

import java.util.*;

public class DistKBT {

    private void markParents(Node root, Map<Node,Node> parent_tract, Node target){

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()){
            Node cur = q.poll();
            if (cur.left != null){
                parent_tract.put(cur.left,cur);
                q.offer(cur.left);
            }
            if (cur.right != null){
                parent_tract.put(cur.right,cur);
                q.offer(cur.right);
            }
        }
    }


    public List<Integer> distanceK(Node root, Node target, int k){
        Map<Node, Node> parent_track = new HashMap<>();

        markParents(root, parent_track,target);

        Map<Node, Boolean> visited = new HashMap<>();

        Queue<Node> q =new LinkedList<>();

        q.offer(target);
        visited.put(target,true);

        int cur_level = 0;

        while (!q.isEmpty()){
            int size = q.size();

            if (cur_level == k) break;
            cur_level++;

            for (int i =0;i<size;i++){
                Node cur = q.poll();

                assert cur != null;
                if (cur.left != null && visited.get(cur.left) == null ){
                    q.offer(cur.left);
                    visited.put(cur.left,true);
                }

                if (cur.right != null && visited.get(cur.right) == null){
                    q.offer(cur.right);
                    visited.put(cur.right,true);
                }

                if (parent_track.get(cur) != null && visited.get(parent_track.get(cur)) == null){
                    q.offer(parent_track.get(cur));
                    visited.put(parent_track.get(cur), true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()){
            Node cur = q.poll();
            result.add(cur.data);
        }

        return result;
    }



}
