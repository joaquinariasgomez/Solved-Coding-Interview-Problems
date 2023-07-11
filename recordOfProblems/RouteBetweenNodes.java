import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RouteBetweenNodes {
    class Graph {
        public ArrayList<ArrayList<Integer>> adjacencyList;

        public Graph(ArrayList<ArrayList<Integer>> adjacencyList) {
            this.adjacencyList = adjacencyList;
        }

        public void printAdjacency() {
            for (int i = 0; i < adjacencyList.size(); i++) {
                List<Integer> currentList = adjacencyList.get(i);
                for (int j = 0; j < currentList.size() - 1; j++) {
                    System.out.print(currentList.get(j) + ", ");
                }
                if (currentList.size() > 0)
                    System.out.println(currentList.get(currentList.size() - 1));
            }
        }
    }

    public boolean AreConnected(Graph g, int a, int b) {
        Stack<Integer> nodes = new Stack<Integer>();
        boolean[] visited = new boolean[g.adjacencyList.size()];

        nodes.push(a);
        visited[a] = true;
        while (!nodes.isEmpty()) {
            int currentNode = nodes.pop();
            System.out.println("Visited: " + currentNode);
            if(currentNode == b) return true;
            if (g.adjacencyList.get(currentNode).size() > 0) {
                // Push adjacents of currentNode
                ArrayList<Integer> adjacents = g.adjacencyList.get(currentNode);
                for (int i = 0; i < adjacents.size(); i++) {
                    if (!visited[adjacents.get(i)]) {
                        nodes.push(adjacents.get(i));
                        visited[adjacents.get(i)] = true;
                    }
                }
            }
        }

        return false;
    }

    public void run() {
        ArrayList<ArrayList<Integer>> adjacency = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 14; i++) {
            adjacency.add(new ArrayList<Integer>());
        }
        adjacency.get(2).add(4);
        adjacency.get(4).add(2);
        adjacency.get(4).add(5);
        adjacency.get(4).add(8);
        adjacency.get(5).add(4);
        adjacency.get(8).add(4);
        adjacency.get(9).add(10);
        adjacency.get(10).add(9);
        adjacency.get(10).add(13);
        adjacency.get(13).add(10);
        Graph mygraph = new Graph(adjacency);
        mygraph.printAdjacency();
        System.out.println(AreConnected(mygraph, 2, 10));
    }

    public static void main(String[] args) {
        new RouteBetweenNodes().run();
    }
}