public class RotateMatrix {

    public void printMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int first = 0;
        int last = matrix.length-1;

        while(first < last) {
            for(int i=first; i<last; i++) {
                int offset = i-first;
                int tmp = matrix[first][i];

                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = tmp; 
            }
            first++;
            last--;
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
        rotate(matrix);
        printMatrix(matrix);
    }
    public static void main(String[] args) {
        new RotateMatrix().run();
    }
}