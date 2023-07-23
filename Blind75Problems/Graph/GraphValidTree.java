import java.util.*;

public class GraphValidTree {

    public int countNodesDFS(int node, List<List<Integer>> adj, HashSet<Integer> visited) {
        if(visited.contains(node)) {
            return 0;
        }
        visited.add(node);
        int neighbourCount = 0;
        for(int neighbour : adj.get(node)) {
            neighbourCount += countNodesDFS(neighbour, adj, visited);
        }
        return 1+neighbourCount;
    }

    public boolean areCycles(int node, int father, List<List<Integer>> adj, HashSet<Integer> visited) {
        System.out.println(node);
        if(visited.contains(node)) {
            return true;
        }
        visited.add(node);
        for(int neighbour : adj.get(node)) {
            if(neighbour != father && areCycles(neighbour, node, adj, visited)) {   // Visit every node except for the father
                return true;
            }
        }
        return false;
    }

    public List<List<Integer>> buildAdjFromEdges(List<List<Integer>> edges) {
        List<List<Integer>> sol = new ArrayList<>();
        int nNodes = 0;
        for(List<Integer> edge : edges) {
            nNodes = Math.max(nNodes, Math.max(edge.get(0), edge.get(1)));
        }
        nNodes++;
        for(int i=0; i<nNodes; i++) {
            sol.add(new ArrayList<>());
        }
        for(List<Integer> edge : edges) {
            sol.get(edge.get(0)).add(edge.get(1));
            sol.get(edge.get(1)).add(edge.get(0));
        }
        return sol;
    }

    public boolean isTree(List<List<Integer>> edges) {
        HashSet<Integer> visited = new HashSet<Integer>();
        if(edges == null) return true;
        List<List<Integer>> adj = buildAdjFromEdges(edges);
        int count = countNodesDFS(0, adj, visited);
        visited = new HashSet<Integer>();
        boolean areCycles = areCycles(0, -1, adj, visited);
        if(areCycles || count < adj.size()) {
            return false;
        }
        return true;
    }

    public void run() {
        List<List<Integer>> edges = Arrays.asList(Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4));
        System.out.println(isTree(edges));
    }

    public static void main(String[] args) {
        new GraphValidTree().run();
    }
}