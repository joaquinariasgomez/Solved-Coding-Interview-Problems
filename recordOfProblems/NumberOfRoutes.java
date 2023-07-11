public class NumberOfRoutes {

    public int getNumberOfRoutesToEnd(int[][] matrix) {
        int i = 0;
        int j = 0;
        int[] recCalls = new int[1]; recCalls[0] = 0;
        int sol = getNumberToEnd(matrix, i, j, recCalls);
        System.out.println("Number of rec calls: "+recCalls[0]);
        return sol;
    }

    public int getNumberToEnd(int[][] matrix, int i, int j, int[] recCalls) {
        recCalls[0]++;
        if(i>matrix.length-1 || j>matrix[0].length-1) {
            return 0;
        }
        else {
            if(i==matrix.length-1 && j==matrix[0].length-1) {
                return 1;
            }
            else {
                return getNumberToEnd(matrix, i+1, j, recCalls) + getNumberToEnd(matrix, i, j+1, recCalls);
            }
        }
    }

    public int getNumberOfRoutesToEndMemo(int[][] matrix) {
        int i = 0;
        int j = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int x=0; x<memo.length; x++) {
            for(int y=0; y<memo[0].length; y++) {
                memo[x][y] = -1;
            }
        }
        int[] recCalls = new int[1]; recCalls[0] = 0;
        int sol = getNumberToEndMemo(matrix, memo, i, j, recCalls);
        System.out.println("Number of rec calls: "+recCalls[0]);
        return sol;
    }

    public int getNumberToEndMemo(int[][] matrix, int[][] memo, int i, int j, int[] recCalls) {
        recCalls[0]++;
        if(i>matrix.length-1 || j>matrix[0].length-1) {
            return 0;
        }
        else {
            if(i==matrix.length-1 && j==matrix[0].length-1) {
                memo[i][j] = 1;
                return memo[i][j];
            }
            else {
                if(memo[i][j] != -1) {
                    return memo[i][j];
                }
                memo[i][j] = getNumberToEndMemo(matrix, memo, i+1, j, recCalls) + getNumberToEndMemo(matrix, memo, i, j+1, recCalls);
                return memo[i][j];
            }
        }
    }

    public void run() {
        int[][] matrix =   {{0, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
        System.out.println(getNumberOfRoutesToEnd(matrix)); // Get number of routes from 0,0 to 2,2 just by moving right or down
        System.out.println(getNumberOfRoutesToEndMemo(matrix)); // Get number of routes from 0,0 to 2,2 just by moving right or down
    }
    public static void main(String[] args) {
        new NumberOfRoutes().run();
    }
}