public class MaximumValuePath {

    public int getMaxSumPath(int[][] matrix) {
        int i = 0;
        int j = 0;
        int[] nCalls = { 0 };
        int sol = getMaxSumPathRec(matrix, i, j, nCalls);
        System.out.println("Number of calls: " + nCalls[0]);
        return sol;
    }

    public int getMaxSumPathRec(int[][] matrix, int i, int j, int[] nCalls) {
        nCalls[0]++;
        if (i > matrix.length - 1 || j > matrix[0].length - 1) {
            return Integer.MIN_VALUE;
        }
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        } else {
            int maxRight = getMaxSumPathRec(matrix, i, j + 1, nCalls);
            int maxDown = getMaxSumPathRec(matrix, i + 1, j, nCalls);
            return matrix[i][j] + Math.max(maxRight, maxDown);
        }
    }

    public int getMaxSumPathMemo(int[][] matrix) {
        int i = 0;
        int j = 0;
        int[] nCalls = { 0 };
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int x = 0; x < memo.length; x++) {
            for (int y = 0; y < memo[0].length; y++) {
                memo[x][y] = -1;
            }
        }
        int sol = getMaxSumPathMemoRec(matrix, i, j, memo, nCalls);
        System.out.println("Number of calls: " + nCalls[0]);
        return sol;
    }

    public int getMaxSumPathMemoRec(int[][] matrix, int i, int j, int[][] memo, int[] nCalls) {
        nCalls[0]++;
        if (i > matrix.length - 1 || j > matrix[0].length - 1) {
            return Integer.MIN_VALUE;
        }
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            memo[i][j] = matrix[i][j];
            return memo[i][j];
        } else {
            if(memo[i][j] != -1) {
                return memo[i][j];
            }
            int maxRight = getMaxSumPathMemoRec(matrix, i, j + 1, memo, nCalls);
            int maxDown = getMaxSumPathMemoRec(matrix, i + 1, j, memo, nCalls);
            memo[i][j] = matrix[i][j] + Math.max(maxRight, maxDown);
            return memo[i][j];
        }
    }

    public void run() {
        int[][] matrix = { { 1, 8, 7 },
                { 3, 4, 2 },
                { 5, 6, 9 } };
        System.out.println(getMaxSumPath(matrix));
        System.out.println(getMaxSumPathMemo(matrix));
    }

    public static void main(String[] args) {
        new MaximumValuePath().run();
    }
}