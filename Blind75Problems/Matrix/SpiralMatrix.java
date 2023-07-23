import java.util.*;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> sol = new ArrayList<Integer>();
        if (matrix.length == 0)
            return sol;
        int beginRow = 0;
        int endRow = matrix.length - 1;
        int beginCol = 0;
        int endCol = matrix[0].length - 1;

        while (beginRow <= endRow && beginCol <= endCol) {
            // Move right
            for (int i = beginCol; i <= endCol; i++) {
                sol.add(matrix[beginRow][i]);
            }
            // Move down
            for (int i = beginRow+1; i <= endRow; i++) {
                sol.add(matrix[i][endCol]);
            }
            // Move left
            if (beginRow < endRow) {
                for (int i = endCol - 1; i >= beginCol; i--) {
                    sol.add(matrix[endRow][i]);
                }
            }
            // Move up
            if (beginCol < endCol) {
                for (int i = endRow - 1; i >= beginRow + 1; i--) {
                    sol.add(matrix[i][beginCol]);
                }
            }
            beginRow++;
            endRow--;
            beginCol++;
            endCol--;
        }
        return sol;
    }

    public void run() {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 12, 13, 14, 5 },
                { 11, 16, 15, 6 },
                { 10, 9, 8, 7 },
        };
        int[][] matrix2 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        List<Integer> sol = spiralOrder(matrix2);
        for (int el : sol) {
            System.out.print(el + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new SpiralMatrix().run();
    }
}