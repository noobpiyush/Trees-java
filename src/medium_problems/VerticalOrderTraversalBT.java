package medium_problems;

import binaryTree1.Node;

import java.util.*;

public class VerticalOrderTraversalBT {

    public static List<List<Integer>> verticalOrderTraversal(Node root) {
        // Map to store nodes based on vertical and level information
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

        // Queue for BFS traversal
        Queue<Pair<Node, Pair<Integer, Integer>>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, new Pair<>(0, 0))); // Add root at (x=0, y=0)

        // BFS traversal
        while (!queue.isEmpty()) {
            Pair<Node, Pair<Integer, Integer>> p = queue.poll();
            Node temp = p.getKey();
            int x = p.getValue().getKey(); // Vertical position
            int y = p.getValue().getValue(); // Level position

            // Add the node value to the map
            map.computeIfAbsent(x, k -> new TreeMap<>())
                    .computeIfAbsent(y, k -> new ArrayList<>())
                    .add(temp.data);

            // Process left child
            if (temp.left != null) {
                queue.add(new Pair<>(temp.left, new Pair<>(x - 1, y + 1)));
            }

            // Process right child
            if (temp.right != null) {
                queue.add(new Pair<>(temp.right, new Pair<>(x + 1, y + 1)));
            }
        }

        // Construct the result from the map
        List<List<Integer>> result = new ArrayList<>();
        for (Map<Integer, List<Integer>> levels : map.values()) {
            List<Integer> column = new ArrayList<>();
            for (List<Integer> values : levels.values()) {
                Collections.sort(values);
                column.addAll(values);
            }
            result.add(column);
        }

        return result;
    }

    // Custom Pair class
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
