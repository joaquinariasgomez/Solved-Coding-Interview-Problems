import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestReach {

    public List<List<Integer>> getAdjacencyList(List<List<Integer>> edges, int n) {
        List<List<Integer>> adjacency = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adjacency.add(i, new ArrayList<Integer>());
        }
        for(List<Integer> edge : edges) {
            adjacency.get(edge.get(0)-1).add(edge.get(1)-1);
        }
        return adjacency;
    }

    public List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Integer[] distFromOriginToNodes = new Integer[n];
        List<Integer> sol = new ArrayList<Integer>();
        for(int i=0; i<n; i++) distFromOriginToNodes[i] = -1;
        List<List<Integer>> adjacency = getAdjacencyList(edges, n);
        queue.add(s-1);   // Add starting node
        boolean[] visited = new boolean[n];
        for(int i=0; i<visited.length; i++) visited[i] = false;
        visited[s-1] = true;
        int currentDistance = 0;
    
        while(!queue.isEmpty()) {
            int currentNodesSize = queue.size();
            for(int i=0; i<currentNodesSize; i++) {
                int current = queue.poll();
                distFromOriginToNodes[current] = currentDistance;
                for(int adjacent : adjacency.get(current)) {
                    if(!visited[adjacent]) {
                        queue.add(adjacent);
                        visited[adjacent] = true;
                    }
                }
            }
            currentDistance += 6;
        }
        
        for(int i=0; i<n; i++) {
            if((i+1) != s) {
                sol.add(distFromOriginToNodes[i]);
            }
        }
        return sol;
    }

    public void run() {
        List<List<Integer>> edges = Arrays.asList(Arrays.asList(1, 2),
                                                  Arrays.asList(1, 3),
                                                  Arrays.asList(3, 4));
        int n = 5;
        List<Integer> weights = bfs(n, 0, edges, 1);
        for(int a : weights) {
            System.out.print(a+" ");
        }
    }
    public static void main(String[] args) {
        new ShortestReach().run();
    }
}
