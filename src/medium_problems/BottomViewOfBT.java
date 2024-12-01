package medium_problems;

import binaryTree1.Node;

import java.util.*;

public class BottomViewOfBT {

    public static void main(String[] args) {
//        List<Integer> ans = new ArrayList<>();

//        System.out.println(ans.size());
    }

    public  static ArrayList<Integer> bottomViewBT(Node root){

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair<Node,Integer>> q = new LinkedList<>();

        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()){

            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int line = pair.getValue();

            map.put(line,node.data);

            if (node.left != null){
                q.add(new Pair<>(node.left,line - 1));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
    public static class Pair<K,V> {
        K key;
        V val;

        public Pair (K key, V value){
            this.key = key;
            this.val = value;
        }

        public void addKey(K key){
            this.key = key;
        }

        public void addVal(V val){
            this.val = val;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return val;
        }
    }
}
