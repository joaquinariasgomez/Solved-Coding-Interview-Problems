import java.util.Queue;
import java.util.LinkedList;

public class RemoveIslandsAgain {

    public void printGrid(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                System.out.print(" "+grid[i][j]);
            }
            System.out.println();
        }
    }

    public void EnQueueAdjacents(int[][] grid, boolean[][] visited, Queue<Integer> qrows, Queue<Integer> qcols, int row, int col) {
        int maxRows = grid.length;
        int maxCols = grid[0].length;

        if(row>1 && !visited[row-1][col] && grid[row-1][col]==1) {
            qrows.add(row-1);
            qcols.add(col);
            visited[row-1][col] = true;
        }
        if(row<(maxRows-2) && !visited[row+1][col] && grid[row+1][col]==1) {
            qrows.add(row+1);
            qcols.add(col);
            visited[row+1][col] = true;
        }
        if(col>1 && !visited[row][col-1] && grid[row][col-1]==1) {
            qrows.add(row);
            qcols.add(col-1);
            visited[row][col-1] = true;
        }
        if(col<(maxCols-2) && !visited[row][col+1] && grid[row][col+1]==1) {
            qrows.add(row);
            qcols.add(col+1);
            visited[row][col+1] = true;
        }
    }

    public int[][] removeIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Integer> qrows = new LinkedList<Integer>();
        Queue<Integer> qcols = new LinkedList<Integer>();
        if(grid == null || grid.length < 3 || grid[0].length < 3) return grid;

        for(int j=1; j<grid[0].length-1; j++) { //Transverse row 0
            if(grid[0][j] == 1) {
                //BFS this shit
                if(grid[1][j] == 1) {
                    qrows.add(1);
                    qcols.add(j);
                    visited[1][j] = true;
                    while(!qrows.isEmpty() && !qcols.isEmpty()) {
                        int currRow = qrows.poll();
                        int currCol = qcols.poll();
                        // Treat node
                        grid[currRow][currCol] = 0;
                        EnQueueAdjacents(grid, visited, qrows, qcols, currRow, currCol);
                    }
                }
            }
        }
        for(int j=1; j<grid[0].length-1; j++) { //Transverse last row
            if(grid[grid.length-1][j] == 1) {
                //BFS this shit
                if(grid[grid.length-2][j] == 1) {
                    qrows.add(grid.length-2);
                    qcols.add(j);
                    visited[grid.length-2][j] = true;
                    while(!qrows.isEmpty() && !qcols.isEmpty()) {
                        int currRow = qrows.poll();
                        int currCol = qcols.poll();
                        // Treat node
                        grid[currRow][currCol] = 0;
                        EnQueueAdjacents(grid, visited, qrows, qcols, currRow, currCol);
                    }
                }
            }
        }
        for(int i=1; i<grid.length-1; i++) { //Transverse col 0
            if(grid[i][0] == 1) {
                //BFS this shit
                if(grid[i][1] == 1) {
                    qrows.add(i);
                    qcols.add(1);
                    visited[i][1] = true;
                    while(!qrows.isEmpty() && !qcols.isEmpty()) {
                        int currRow = qrows.poll();
                        int currCol = qcols.poll();
                        // Treat node
                        grid[currRow][currCol] = 0;
                        EnQueueAdjacents(grid, visited, qrows, qcols, currRow, currCol);
                    }
                }
            }
        }
        for(int i=1; i<grid.length-1; i++) { //Transverse last col
            if(grid[i][grid[0].length-1] == 1) {
                //BFS this shit
                if(grid[i][grid[0].length-2] == 1) {
                    qrows.add(i);
                    qcols.add(grid[0].length-2);
                    visited[i][grid[0].length-2] = true;
                    while(!qrows.isEmpty() && !qcols.isEmpty()) {
                        int currRow = qrows.poll();
                        int currCol = qcols.poll();
                        // Treat node
                        grid[currRow][currCol] = 0;
                        EnQueueAdjacents(grid, visited, qrows, qcols, currRow, currCol);
                    }
                }
            }
        }
        return grid;
    }

    public void run() {
        int[][] grid = {
            {1, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 0, 1, 1},
            {1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1},
        };
        printGrid(grid);
        System.out.println();
        printGrid(removeIslands(grid));
    }
    public static void main(String[] args) {
        new RemoveIslandsAgain().run();
    }
}
