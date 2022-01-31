public class SpiralMatrix {

    public void printSpiral(int[][] matrix) {
        if(matrix == null) return;
        int maxRows = matrix.length;
        int maxCols = matrix[0].length;
        int startCol = 1; int endCol = maxCols - 1;
        int startRow = 1; int endRow = maxRows - 1;

        for(int i=0; i<Math.ceil(maxRows/2.); i++) {
            System.out.println(matrix[i][i]);
            for(int j=startCol; j<=endCol; j++) {
                System.out.println(matrix[i][j]);
            }
            for(int j=startRow; j<=endRow; j++) {
                System.out.println(matrix[j][endCol]);
            }
            if(startRow < endRow) {
                for(int j=endCol-1; j>=startCol-1; j--) {
                    System.out.println(matrix[endRow][j]);
                }
            }
            if(startCol < endCol) {
                for(int j=endRow-1; j>=startRow; j--) {
                    System.out.println(matrix[j][startCol-1]);
                }
            }
            startCol++;
            endCol--;
            startRow++;
            endRow--;
        }
    }

    public void run() {
        int[][] matrix = {
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7},
        };
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        printSpiral(matrix2);
    }
    public static void main(String[] args) {
        new SpiralMatrix().run();
    }
}
