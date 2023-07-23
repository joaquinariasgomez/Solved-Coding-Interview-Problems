import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public void fillIsland(char[][] grid, int i, int j) {
        Queue<Integer> rows = new LinkedList<Integer>();
        Queue<Integer> cols = new LinkedList<Integer>();
        rows.add(i);
        cols.add(j);
        while (!rows.isEmpty() && !cols.isEmpty()) {
            int currRow = rows.poll();
            int currCol = cols.poll();
            if (grid[currRow][currCol] == '1') {
                grid[currRow][currCol] = '0';
                pushAdjacents(grid, currRow, currCol, rows, cols);
            }
        }
    }

    public void pushAdjacents(char[][] grid, int currRow, int currCol, Queue<Integer> rows, Queue<Integer> cols) {
        if (currRow < grid.length - 1) {
            rows.add(currRow + 1);
            cols.add(currCol);
        }
        if (currRow > 0) {
            rows.add(currRow - 1);
            cols.add(currCol);
        }
        if (currCol < grid[0].length - 1) {
            rows.add(currRow);
            cols.add(currCol + 1);
        }
        if (currCol > 0) {
            rows.add(currRow);
            cols.add(currCol - 1);
        }
    }

    public int nIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    fillIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    public void run() {
        char[][] grid = new char[4][5];
        grid[0] = new char[] { '1', '1', '1', '1', '0' };
        grid[1] = new char[] { '1', '1', '0', '1', '0' };
        grid[2] = new char[] { '1', '1', '0', '0', '0' };
        grid[3] = new char[] { '0', '0', '0', '0', '0' };
        System.out.println(nIslands(grid));
    }

    public static void main(String[] args) {
        new NumberOfIslands().run();
    }
}