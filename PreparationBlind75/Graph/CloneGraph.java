import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public void printGraph(Node node, HashSet<Node> seen) {
        if (!seen.contains(node)) {
            System.out.print(node.val + " ");
            seen.add(node);
            for (Node neighbor : node.neighbors) {
                printGraph(neighbor, seen);
            }
        }
    }

    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        return dfs(node, map);
    }

    public Node dfs(Node node, HashMap<Integer, Node> map) {
        if(node == null) return null;
        if(map.containsKey(node.val)) return map.get(node.val);
        Node copy_node = new Node(node.val);
        map.put(node.val, copy_node);

        for(Node neighbor : node.neighbors) {
            copy_node.neighbors.add(dfs(neighbor, map));
        }
        return copy_node;
    }

    public void run() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        printGraph(node1, new HashSet<Node>());
        Node copy = cloneGraph(node1);
        System.out.println();
        printGraph(copy, new HashSet<Node>());
    }

    public static void main(String[] args) {
        new CloneGraph().run();
    }
}