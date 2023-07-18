import java.util.*;

public class PacificAtlanticWaterFlow {

    public boolean canGetToPacific(int i, int j, int[][] heights, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length)
            return false;
        visited[i][j] = true;
        if (i == 0 || j == 0)
            return true;

        boolean canGet = false;
        if (i < heights.length - 1 && !visited[i + 1][j] && heights[i + 1][j] <= heights[i][j])
            canGet = canGet || canGetToPacific(i + 1, j, heights, visited);
        if (i > 0 && !visited[i - 1][j] && heights[i - 1][j] <= heights[i][j])
            canGet = canGet || canGetToPacific(i - 1, j, heights, visited);
        if (j < heights[0].length - 1 && !visited[i][j + 1] && heights[i][j + 1] <= heights[i][j])
            canGet = canGet || canGetToPacific(i, j + 1, heights, visited);
        if (j > 0 && !visited[i][j - 1] && heights[i][j - 1] <= heights[i][j])
            canGet = canGet || canGetToPacific(i, j - 1, heights, visited);
        return canGet;
    }

    public boolean canGetToAtlantic(int i, int j, int[][] heights, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length)
            return false;
        visited[i][j] = true;
        if (i == heights.length - 1 || j == heights[0].length - 1)
            return true;

        boolean canGet = false;
        if (i < heights.length - 1 && !visited[i + 1][j] && heights[i + 1][j] <= heights[i][j])
            canGet = canGet || canGetToAtlantic(i + 1, j, heights, visited);
        if (i > 0 && !visited[i - 1][j] && heights[i - 1][j] <= heights[i][j])
            canGet = canGet || canGetToAtlantic(i - 1, j, heights, visited);
        if (j < heights[0].length - 1 && !visited[i][j + 1] && heights[i][j + 1] <= heights[i][j])
            canGet = canGet || canGetToAtlantic(i, j + 1, heights, visited);
        if (j > 0 && !visited[i][j - 1] && heights[i][j - 1] <= heights[i][j])
            canGet = canGet || canGetToAtlantic(i, j - 1, heights, visited);
        return canGet;
    }

    public boolean canGetToBoth(int i, int j, int[][] heights) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        boolean canPacific = canGetToPacific(i, j, heights, visited);
        visited = new boolean[heights.length][heights[0].length];
        boolean canAtlantic = canGetToAtlantic(i, j, heights, visited);
        return canAtlantic && canPacific;
    }

    public List<List<Integer>> getPointCoords(int[][] heights) {
        List<List<Integer>> sol = new ArrayList<>();
        int[][] canGetToBothOceans = new int[heights.length][heights[0].length];
        for (int i = 0; i < canGetToBothOceans.length; i++) {
            for (int j = 0; j < canGetToBothOceans[0].length; j++) {
                canGetToBothOceans[i][j] = -1;
            }
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (canGetToBothOceans[i][j] == -1) { // If it is set, we dont need to do the recursion
                    if (canGetToBoth(i, j, heights)) {
                        canGetToBothOceans[i][j] = 1;
                    } else {
                        canGetToBothOceans[i][j] = 0;
                    }
                }
            }
        }
        // Deencoding of solution from canGetToBothOceans
        for (int i = 0; i < canGetToBothOceans.length; i++) {
            for (int j = 0; j < canGetToBothOceans[0].length; j++) {
                if(canGetToBothOceans[i][j] == 1) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i); pair.add(j);
                    sol.add(pair);
                }
            }
        }
        return sol;
    }

    public void run() {
        int[][] heights = new int[5][5];
        heights[0] = new int[] { 1, 2, 2, 3, 5 };
        heights[1] = new int[] { 3, 2, 3, 4, 4 };
        heights[2] = new int[] { 2, 4, 5, 3, 1 };
        heights[3] = new int[] { 6, 7, 1, 4, 5 };
        heights[4] = new int[] { 5, 1, 1, 2, 4 };
        List<List<Integer>> sol = getPointCoords(heights);
    }

    public static void main(String[] args) {
        new PacificAtlanticWaterFlow().run();
    }
}