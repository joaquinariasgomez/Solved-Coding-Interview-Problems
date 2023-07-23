public class SetMatrixZeroes {

    public void printMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean row0 = false;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if(i==0) {
                        row0 = true;
                    } else {
                        matrix[i][0] = 0;
                    }
                }
            } 
        }
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            } 
        }
        if(matrix[0][0] == 0) { //Set to zeroes first col
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }
        if(matrix[0][0] == 0) { //Set to zeroes first col
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }
        if(row0) {  //Set to zeroes first row
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }
    }

    public void run() {
        int[][] matrix = { { 0, 1, 2, 0 },
                            { 3, 4, 5, 2 },
                            {1, 3, 1, 5} };
        setZeroes(matrix);
        printMatrix(matrix);
    }

    public static void main(String[] args) {
        new SetMatrixZeroes().run();
    }
}