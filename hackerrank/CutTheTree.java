import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CutTheTree {

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
    
    public int minAbsoluteDifference(List<Integer> data, List<List<Integer>> edges) {
        int minDiff = Integer.MAX_VALUE;
        int nNodes = data.size();
        List<List<Integer>> adjacency = getAdjacencyList(edges, nNodes);

        for(List<Integer> edge : edges) {
            boolean[] visited = new boolean[nNodes];
            visited[edge.get(0)-1] = true;
            visited[edge.get(1)-1] = true;
            // Left sub-graph
            int leftSubGraphSum = 0;
            Stack<Integer> leftStack = new Stack<Integer>();
            leftStack.add(edge.get(0)-1);
            while(!leftStack.isEmpty()) {
                int currentNode = leftStack.pop();
                leftSubGraphSum += data.get(currentNode);
                for(int adjacent : adjacency.get(currentNode)) {
                    if(!visited[adjacent]) {
                        visited[adjacent] = true;
                        leftStack.push(adjacent);
                    }
                }
            }
            // Right sub-graph
            int rightSubGraphSum = 0;
            Stack<Integer> rightStack = new Stack<Integer>();
            rightStack.add(edge.get(1)-1);
            while(!rightStack.isEmpty()) {
                int currentNode = rightStack.pop();
                rightSubGraphSum += data.get(currentNode);
                for(int adjacent : adjacency.get(currentNode)) {
                    if(!visited[adjacent]) {
                        visited[adjacent] = true;
                        rightStack.push(adjacent);
                    }
                }
            }
            minDiff = Math.min(minDiff, Math.abs(rightSubGraphSum-leftSubGraphSum));
        }
        return minDiff;
    }

    public void run() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<List<Integer>> edges = Arrays.asList(Arrays.asList(1, 2),
                                                  Arrays.asList(1, 3),
                                                  Arrays.asList(2, 6),
                                                  Arrays.asList(3, 4),
                                                  Arrays.asList(3, 5));
        System.out.println(minAbsoluteDifference(data, edges));
    }
    public static void main(String[] args) {
        new CutTheTree().run();
    }
}
