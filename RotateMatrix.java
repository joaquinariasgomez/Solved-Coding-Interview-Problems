public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int rows = matrix.length;

        for(int layer=0; layer<Math.ceil(rows/2.); layer++) {
            int first = layer;
            int last = rows-1-layer;

            for(int i=first; i<last; i++) {
                int offset = i-first;
                int top = matrix[first][i]; // save top

                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top; 
            }
        }
    }

    public void run() {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        rotate(matrix);
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new RotateMatrix().run();
    }
}
