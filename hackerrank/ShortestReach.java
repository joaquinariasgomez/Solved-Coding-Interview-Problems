import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestReach {

    public void printAdjacencyList(List<List<Integer>> adjacency, int n) {
        for(int i=0; i<n; i++) {
            System.out.print((i+1)+" -> ");
            for(int adjacent : adjacency.get(i)) {
                System.out.print((adjacent+1)+" ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> getAdjacencyList(List<List<Integer>> edges, int n) {
        List<List<Integer>> adjacency = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adjacency.add(i, new ArrayList<Integer>());
        }
        for(List<Integer> edge : edges) {
            adjacency.get(edge.get(0)-1).add(edge.get(1)-1);
            adjacency.get(edge.get(1)-1).add(edge.get(0)-1);
        }
        return adjacency;
    }

    public List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<Integer> sol = new ArrayList<Integer>();
        List<List<Integer>> adjacency = getAdjacencyList(edges, n);
        Integer[] distFromOriginToNode = new Integer[n];
        for(int i=0; i<n; i++) distFromOriginToNode[i] = -1;
        boolean[] visited = new boolean[n];
        visited[s-1] = true;     // Adapt from 1 to 0
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s-1);
        int traveledDistanceFromOrigin = 0;
       
        while(!queue.isEmpty()) {
            int currLevelSize = queue.size();
            for(int i=0; i<currLevelSize; i++) {
                int currentNode = queue.poll();
                distFromOriginToNode[currentNode] = traveledDistanceFromOrigin;
                for(int adjacent : adjacency.get(currentNode)) {
                    if(!visited[adjacent]) {
                        visited[adjacent] = true;
                        queue.add(adjacent);
                    }
                }
            }
            traveledDistanceFromOrigin+=6;
        }
       
        for(int i=0; i<n; i++) {
            if(distFromOriginToNode[i] != 0) {
                sol.add(distFromOriginToNode[i]);
            }
        }
        return sol;
    }

    public void run() {
        List<List<Integer>> edges = Arrays.asList(Arrays.asList(1, 2),
                                                  Arrays.asList(1, 3),
                                                  Arrays.asList(3, 4));
        int n = 5;
        List<Integer> weights = bfs(n, 3, edges, 1);
        for(int a : weights) {
            System.out.print(a+" ");
        }
    }
    public static void main(String[] args) {
        new ShortestReach().run();
    }
}
