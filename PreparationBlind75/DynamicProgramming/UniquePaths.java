public class UniquePaths {

    public int numberOfPathsRec(int m, int n, int currM, int currN, int[][] memo) {
        if(currM == (m-1) && currN == (n-1)) return 1;
        if(currM < 0 || currM >= m || currN < 0 || currN >= n) return 0;
        if(memo[currM][currN] != -1) return memo[currM][currN];
        int nPathsRight = numberOfPathsRec(m, n, currM, currN+1, memo);
        int nPathsDown = numberOfPathsRec(m, n, currM+1, currN, memo);
        memo[currM][currN] = nPathsRight + nPathsDown;
        return memo[currM][currN];
    }

    public int numberOfPaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i=0; i<memo.length; i++) {
            for(int j=0; j<memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return numberOfPathsRec(m, n, 0, 0, memo);
    }

    public void run() {
        int m = 3, n = 7;
        System.out.println(numberOfPaths(m, n));
    }
    public static void main(String[] args) {
        new UniquePaths().run();
    }
}