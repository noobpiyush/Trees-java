package medium_problems;

import binaryTree1.Node;

import java.util.*;

public class TopViewOfBT {

   public static ArrayList<Integer> topViewOfBT(Node root){

       ArrayList<Integer> ans = new ArrayList<>();

       if (root == null) return ans;

       Map<Integer, Integer> map = new TreeMap<>();

       Queue<Pair<Node, Integer>> q = new LinkedList<>();

       q.add(new Pair<>(root,0));

       while (!q.isEmpty()){

           Pair<Node,Integer> pair = q.poll();

           Node node = pair.getKey();
           int line = pair.getValue();

           // If the vertical position is not already
           // in the map, add the node's data to the map

           if (!map.containsKey(line)){
               map.put(line,node.data);
           }

           if (node.left != null){
               q.add(new Pair<>(node.left, line - 1));
           }

           if (node.right != null){
               q.add(new Pair<>(node.right, line + 1));
           }
       }

       for (int val : map.values()){
           ans.add(val);
       }

       return ans;
   }

   public static  class  Pair<K,V>{
       private K key;
       private  V value;

       public Pair(K key, V value){
           this.key = key;
           this.value = value;
       }

       public K getKey(){
           return key;
       }

       public V getValue(){
           return value;
       }

       public void  setKey(K key){
           this.key = key;
       }

       public void setValue(V val){
           this.value = val;
       }
   }
}
