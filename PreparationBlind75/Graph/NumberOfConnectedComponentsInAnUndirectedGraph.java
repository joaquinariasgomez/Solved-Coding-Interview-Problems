import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public List<List<Integer>> buildAdj(List<List<Integer>> edges) {
        int nNodes = 0;
        for(List<Integer> edge : edges) {
            nNodes = Math.max(Math.max(nNodes, edge.get(0)), edge.get(1));
        }
        nNodes++;
        List<List<Integer>> sol = new ArrayList<>();
        for(int i=0; i<nNodes; i++) {
            sol.add(new ArrayList<Integer>());
        }
        for(List<Integer> edge : edges) {
            sol.get(edge.get(0)).add(edge.get(1));
        }
        return sol;
    }

    public void fillWithDFS(int node, HashSet<Integer> visited, List<List<Integer>> adj) {
        if(visited.contains(node)) return;
        visited.add(node);
        for(int neighbour : adj.get(node)) {
            fillWithDFS(neighbour, visited, adj);
        }
    }

    public int numberOfComps(List<List<Integer>> edges) {
        List<List<Integer>> adj = buildAdj(edges);
        HashSet<Integer> visited = new HashSet<Integer>();
        int sol = 0;

        for(int node=0; node<adj.size(); node++) {
            if(!visited.contains(node)) {
                sol++;
                fillWithDFS(node, visited, adj);
            }
        }
        return sol;
    } 

    public void run() {
        List<List<Integer>> edges = Arrays.asList(Arrays.asList(0, 1),
                                                  Arrays.asList(1, 2),
                                                  Arrays.asList(3, 4));
        System.out.println(numberOfComps(edges));
    }
    public static void main(String[] args) {
        new NumberOfConnectedComponentsInAnUndirectedGraph().run();
    }
}