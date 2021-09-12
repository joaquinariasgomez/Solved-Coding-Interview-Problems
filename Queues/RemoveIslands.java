import java.util.LinkedList;
import java.util.Queue;

public class RemoveIslands {
    public static void printGrid(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                System.out.print(" "+grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void EnQueueAdjacents(int[][] grid, int row, int col, Queue<Integer> qrow, Queue<Integer> qcol, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(row>1 && !visited[row-2][col-1] && grid[row-1][col] == 1) {
            qrow.offer(row-1);
            qcol.offer(col);
        }
        if(col>1 && !visited[row-1][col-2] && grid[row][col-1] == 1) {
            qrow.offer(row);
            qcol.offer(col-1);
        }
        if(row<(rows-2) && !visited[row][col-1] && grid[row+1][col] == 1) {
            qrow.offer(row+1);
            qcol.offer(col);
        }
        if(col<(cols-2) && !visited[row-1][col] && grid[row][col+1] == 1) {
            qrow.offer(row);
            qcol.offer(col+1);
        }
    }

    public static boolean isAdjacentWithWhite(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(grid[i][j] == 1) {
            boolean isAdjacent = false;
            if(i==1 && (grid[i-1][j] == 1)) {isAdjacent = true;}
            if(j==1 && (grid[i][j-1] == 1)) {isAdjacent = true;}
            if(i==(rows-2) && (grid[i+1][j] == 1)) {isAdjacent = true;}
            if(j==(cols-2) && (grid[i][j+1] == 1)) {isAdjacent = true;}
            return isAdjacent;
        }
        else {
            return false;
        }
    }

    public static int[][] removeIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows-1][cols-1];
        Queue<Integer> qrow = new LinkedList<Integer>();
        Queue<Integer> qcol = new LinkedList<Integer>();

        for(int i=0; i<visited.length; i++) {
            for(int j=0; j<visited[0].length; j++) {
                visited[i][j] = false;
            }
        }

        for(int i=1; i<rows-1; i++) {
            for(int j=1; j<cols-1; j++) {
                if(isAdjacentWithWhite(grid, i, j) && !visited[i-1][j-1]) {
                    qrow.add(i);
                    qcol.add(j);
                    while(!qrow.isEmpty() && !qcol.isEmpty()) {
                        int row = qrow.poll();
                        int col = qcol.poll();
                        if(!visited[row-1][col-1]) {
                            visited[row-1][col-1] = true;
                            grid[row][col] = 0;
                            EnQueueAdjacents(grid, row, col, qrow, qcol, visited);
                        }
                    }
                }
            }
        }

        return grid;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1},
        };
        printGrid(grid);
        System.out.println();
        printGrid(removeIslands(grid));
    }
}
