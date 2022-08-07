import java.util.Queue;
import java.util.LinkedList;

public class MaxAreaOfIsland {
    public void printGrid(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int maxArea(int[][] grid) {
        int currentMaxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    // BFS to check the size of this island
                    currentMaxArea = Math.max(currentMaxArea, calculateAreaFrom(grid, visited, i, j));
                }
            }
        }

        return currentMaxArea;
    }

    public int calculateAreaFrom(int[][] grid, boolean[][] visited, int i, int j) {
        int currentArea = 0;
        Queue<Integer> qrow = new LinkedList<>();
        Queue<Integer> qcol = new LinkedList<>();
        qrow.add(i);
        qcol.add(j);
        while (!qrow.isEmpty() && !qcol.isEmpty()) {
            int currRow = qrow.poll();
            int currCol = qcol.poll();
            if (!visited[currRow][currCol]) {
                ++currentArea;
                visited[currRow][currCol] = true;
                EnQueueAdjacents(currRow, currCol, grid, visited, qrow, qcol);
            }
        }

        return currentArea;
    }

    public void EnQueueAdjacents(int currRow, int currCol, int[][] grid, boolean[][] visited, Queue<Integer> qrow,
            Queue<Integer> qcol) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (currRow > 0 && !visited[currRow - 1][currCol] && grid[currRow - 1][currCol] == 1) {
            qrow.add(currRow - 1);
            qcol.add(currCol);
        }
        if (currRow < (rows - 1) && !visited[currRow + 1][currCol] && grid[currRow + 1][currCol] == 1) {
            qrow.add(currRow + 1);
            qcol.add(currCol);
        }
        if (currCol > 0 && !visited[currRow][currCol - 1] && grid[currRow][currCol - 1] == 1) {
            qrow.add(currRow);
            qcol.add(currCol - 1);
        }
        if (currCol < (cols - 1) && !visited[currRow][currCol + 1] && grid[currRow][currCol + 1] == 1) {
            qrow.add(currRow);
            qcol.add(currCol + 1);
        }
    }

    public void run() {
        int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
        printGrid(grid);
        System.out.println(maxArea(grid));
    }

    public static void main(String[] args) {
        new MaxAreaOfIsland().run();
    }
}