import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTransversal {

    public void pushAdjacents(char[][] graph, boolean[][] visited, int row, int col, Stack<Integer> rows, Stack<Integer> cols) {
        int maxRows = graph.length;
        int maxCols = graph[0].length;
        if(row > 0 && col > 0 && !visited[row-1][col-1]) {
            rows.push(row-1);
            cols.push(col-1);
            visited[row-1][col-1] = true;
        }
        if(row > 0 && !visited[row-1][col]) {
            rows.push(row-1);
            cols.push(col);
            visited[row-1][col] = true;
        }
        if(row > 0 && col < maxCols-1 && !visited[row-1][col+1]) {
            rows.push(row-1);
            cols.push(col+1);
            visited[row-1][col+1] = true;
        }
        if(col > 0 && !visited[row][col-1]) {
            rows.push(row);
            cols.push(col-1);
            visited[row][col-1] = true;
        }
        if(col < maxCols-1 && !visited[row][col+1]) {
            rows.push(row);
            cols.push(col+1);
            visited[row][col+1] = true;
        }
        if(col > 0 && row < maxRows-1 && !visited[row+1][col-1]) {
            rows.push(row+1);
            cols.push(col-1);
            visited[row+1][col-1] = true;
        }
        if(row < maxRows-1 && !visited[row+1][col]) {
            rows.push(row+1);
            cols.push(col);
            visited[row+1][col] = true;
        }
        if(col < maxCols-1 && row < maxRows-1 && !visited[row+1][col+1]) {
            rows.push(row+1);
            cols.push(col+1);
            visited[row+1][col+1] = true;
        }
    }

    public void pushAdjacents(char[][] graph, boolean[][] visited, int row, int col, Queue<Integer> rows, Queue<Integer> cols) {
        int maxRows = graph.length;
        int maxCols = graph[0].length;
        if(row > 0 && col > 0 && !visited[row-1][col-1]) {
            rows.add(row-1);
            cols.add(col-1);
            visited[row-1][col-1] = true;
        }
        if(row > 0 && !visited[row-1][col]) {
            rows.add(row-1);
            cols.add(col);
            visited[row-1][col] = true;
        }
        if(row > 0 && col < maxCols-1 && !visited[row-1][col+1]) {
            rows.add(row-1);
            cols.add(col+1);
            visited[row-1][col+1] = true;
        }
        if(col > 0 && !visited[row][col-1]) {
            rows.add(row);
            cols.add(col-1);
            visited[row][col-1] = true;
        }
        if(col < maxCols-1 && !visited[row][col+1]) {
            rows.add(row);
            cols.add(col+1);
            visited[row][col+1] = true;
        }
        if(col > 0 && row < maxRows-1 && !visited[row+1][col-1]) {
            rows.add(row+1);
            cols.add(col-1);
            visited[row+1][col-1] = true;
        }
        if(row < maxRows-1 && !visited[row+1][col]) {
            rows.add(row+1);
            cols.add(col);
            visited[row+1][col] = true;
        }
        if(col < maxCols-1 && row < maxRows-1 && !visited[row+1][col+1]) {
            rows.add(row+1);
            cols.add(col+1);
            visited[row+1][col+1] = true;
        }
    }

    public void depthFirstSearch(char[][] graph) {
        Stack<Integer> rows = new Stack<Integer>();
        Stack<Integer> cols = new Stack<Integer>();
        boolean[][] visited = new boolean[graph.length][graph[0].length];

        rows.push(0);
        cols.push(0);
        visited[0][0] = true;
        while(!rows.isEmpty() && !cols.isEmpty()) {
            int currRow = rows.pop();
            int currCol = cols.pop();
            System.out.println(graph[currRow][currCol]);
            pushAdjacents(graph, visited, currRow, currCol, rows, cols);
        }
    }

    public void depthFirstSearchByLevel(char[][] graph) {
        Stack<Integer> rows = new Stack<Integer>();
        Stack<Integer> cols = new Stack<Integer>();
        boolean[][] visited = new boolean[graph.length][graph[0].length];

        rows.push(0);
        cols.push(0);
        visited[0][0] = true;
        while(!rows.isEmpty() && !cols.isEmpty()) {
            int currStackSize = rows.size();
            for(int i=0; i<currStackSize; i++) {
                int currRow = rows.pop();
                int currCol = cols.pop();
                System.out.print(graph[currRow][currCol]+" ");
                pushAdjacents(graph, visited, currRow, currCol, rows, cols);
            }
            System.out.println();
        }
    }

    public void breadthFirstSearch(char[][] graph) {
        Queue<Integer> rows = new LinkedList<Integer>();
        Queue<Integer> cols = new LinkedList<Integer>();
        boolean[][] visited = new boolean[graph.length][graph[0].length];

        rows.add(0);
        cols.add(0);
        visited[0][0] = true;
        while(!rows.isEmpty() && !cols.isEmpty()) {
            int currRow = rows.poll();
            int currCol = cols.poll();
            System.out.println(graph[currRow][currCol]);
            pushAdjacents(graph, visited, currRow, currCol, rows, cols);
        }
    }

    public void breadthFirstSearchByLevel(char[][] graph) {
        Queue<Integer> rows = new LinkedList<Integer>();
        Queue<Integer> cols = new LinkedList<Integer>();
        boolean[][] visited = new boolean[graph.length][graph[0].length];

        rows.add(0);
        cols.add(0);
        visited[0][0] = true;
        while(!rows.isEmpty() && !cols.isEmpty()) {
            int currLevelSize = rows.size();
            for(int i=0; i<currLevelSize; i++) {
                int currRow = rows.poll();
                int currCol = cols.poll();
                System.out.print(graph[currRow][currCol]+" ");
                pushAdjacents(graph, visited, currRow, currCol, rows, cols);
            }
            System.out.println();
        }
    }

    public void run() {
        char[][] graph = {
            {'x', 'o', ' '},
            {'o', 'x', 'o'},
            {'o', 'x', 'x'},
        };
        char[][] graphLevel = {
            {'1', '2', '3'},
            {'2', '2', '3'},
            {'3', '3', '3'},
        };
        System.out.println("DFS:");
        depthFirstSearch(graph);
        System.out.println("DFS by level:");
        depthFirstSearchByLevel(graphLevel);
        System.out.println("BFS:");
        breadthFirstSearch(graph);
        System.out.println("BFS by level:");
        breadthFirstSearchByLevel(graphLevel);
    }
    public static void main(String[] args) {
        new GraphTransversal().run();
    }
}
