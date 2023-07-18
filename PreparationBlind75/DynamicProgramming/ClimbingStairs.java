public class ClimbingStairs {

    public int nWays(int n) {
        int[] memo = new int[n+1];
        return nWaysRec(0, n, memo);
    }

    public int nWaysRec(int currStair, int n, int[] memo) {
        if(currStair > n) return 0;
        if(currStair == n) {
            memo[currStair] = 1;
            return memo[currStair];
        }
        else {
            if(memo[currStair] > 0) return memo[currStair];
            memo[currStair] = nWaysRec(currStair+1, n, memo) + nWaysRec(currStair+2, n, memo);
            return memo[currStair];
        }
    }

    public void run() {
        int n = 3;
        System.out.println(nWays(n));
    }
    public static void main(String[] args) {
        new ClimbingStairs().run();
    }
}