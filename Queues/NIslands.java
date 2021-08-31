import java.util.Queue;
import java.util.LinkedList;

public class NIslands {
  public void printGrid(char[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    for(int i=0; i<rows; i++) {
      for(int j=0; j<cols; j++) {
        System.out.print(grid[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public void EnQueueAdjacents(int row, int col, char[][] grid, boolean[][] visited, Queue<Integer> qrow, Queue<Integer> qcol) {
    int rows = grid.length;
    int cols = grid[0].length;
    
    if(row>0 && !visited[row-1][col] && grid[row-1][col]=='1') {
      qrow.offer(row-1);
      qcol.offer(col);
    }
    if(row<(rows-1) && !visited[row+1][col] && grid[row+1][col]=='1') {
      qrow.offer(row+1);
      qcol.offer(col);
    }
    if(col>0 && !visited[row][col-1] && grid[row][col-1]=='1') {
      qrow.offer(row);
      qcol.offer(col-1);
    }
    if(col<(cols-1) && !visited[row][col+1] && grid[row][col+1]=='1') {
      qrow.offer(row);
      qcol.offer(col+1);
    }
  }

  public int nIslands(char[][] grid) {
    int islands = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    Queue<Integer> qrow = new LinkedList<Integer>();
    Queue<Integer> qcol = new LinkedList<Integer>();

    boolean[][] visited = new boolean[rows][cols];
    for(int i=0; i<rows; i++) {
      for(int j=0; j<cols; j++) {
        visited[i][j] = false;
      }
    }

    for(int i=0; i<rows; i++) {
      for(int j=0; j<cols; j++) {
        if(grid[i][j] == '1' && !visited[i][j]) {
          qrow.offer(i);
          qcol.offer(j);
          while(!qrow.isEmpty() && !qcol.isEmpty()) {
            int row = qrow.poll();
            int col = qcol.poll();
            if (!visited[row][col]) {
              visited[row][col] = true;
              EnQueueAdjacents(row, col, grid, visited, qrow, qcol);
            }
          }
          ++islands;
        }
      }
    }

    return islands;
  }

  public void run() {
    char[][] grid = {
      {'1', '0', '0', '1'},
      {'0', '1', '1', '0'},
      {'0', '1', '1', '0'},
      {'0', '0', '1', '0'},
    };
    printGrid(grid);
    System.out.println(nIslands(grid));
  }

  public static void main(String[] args) {
    new NIslands().run();
  }
}
