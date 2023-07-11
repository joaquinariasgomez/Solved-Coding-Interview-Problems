public class ClimbingStairs {

    public int calculateNWaysToGetToTop(int n) {
        int[] recCalls = { 0 };
        int sol = calculateNWaysToGetToTopRec(0, n, recCalls);
        System.out.println("Number of recursive calls: " + recCalls[0]);
        return sol;
    }

    public int calculateNWaysToGetToTopMemo(int n) {
        int[] recCalls = { 0 };
        int[] memo = new int[n+1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        int sol = calculateNWaysToGetToTopRecMemo(0, n, memo, recCalls);
        System.out.println("Number of recursive calls: " + recCalls[0]);
        return sol;
    }

    public int calculateNWaysToGetToTopRec(int currStair, int n, int[] recCalls) { // NOT DYNAMIC PROGRAMMING
        recCalls[0]++;
        if (currStair > n) {
            return 0;
        }
        if (currStair == n) {
            return 1;
        } else {
            return calculateNWaysToGetToTopRec(currStair + 1, n, recCalls) +
                    calculateNWaysToGetToTopRec(currStair + 2, n, recCalls);
        }
    }

    public int calculateNWaysToGetToTopRecMemo(int currStair, int n, int[] memo, int[] recCalls) { // DYNAMIC
                                                                                                   // PROGRAMMING
        recCalls[0]++;
        if (currStair > n) {
            return 0;
        }
        if (currStair == n) {
            return 1;
        } else {
            if (memo[currStair] != -1) {
                return memo[currStair];
            }
            memo[currStair] = calculateNWaysToGetToTopRecMemo(currStair + 1, n, memo, recCalls) +
                    calculateNWaysToGetToTopRecMemo(currStair + 2, n, memo, recCalls);
            return memo[currStair];
        }
    }

    public void run() {
        int n = 5;
        System.out.println("Number of ways to climb stairs: " + calculateNWaysToGetToTop(n));
        System.out.println("Number of ways to climb stairs: " + calculateNWaysToGetToTopMemo(n));
    }

    public static void main(String[] args) {
        new ClimbingStairs().run();
    }
}
