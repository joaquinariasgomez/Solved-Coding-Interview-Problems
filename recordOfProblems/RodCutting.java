public class RodCutting {

    // Top down recursive approach. Time O(2^n-1)
    public int maxRevenueTopDownNonDynamicProgramming(int[] p, int n) {
        if(n == 0) return 0;
        int maxRev = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++) {
            maxRev = Math.max(maxRev, p[i-1] + maxRevenueTopDownNonDynamicProgramming(p, n-i));
        }
        return maxRev;
    }

    // Top down recursive with memoization. Time O(n^2)
    public int maxRevenueTopDownMemo(int[] p, int n) {
        int[] memo = new int[n+1];
        for(int i=0; i<=n; i++) {
            memo[i] = Integer.MIN_VALUE;
        }
        return maxRevenueTopDownMemoRec(p, n, memo);
    }

    public int maxRevenueTopDownMemoRec(int[] p, int n, int[] memo) {
        if(memo[n] >= 0) {  // Solution has been calculated previously
            return memo[n];
        }
        int partialSol = Integer.MIN_VALUE;
        if(n==0) {
            partialSol = 0;
        }
        else {
            for(int i=1; i<=n; i++) {
                partialSol = Math.max(partialSol, p[i-1] + maxRevenueTopDownMemoRec(p, n-i, memo));
            }
        }
        memo[n] = partialSol;
        return partialSol;
    }

    // Bottom up with memoization. Time O(n^2)
    public int maxRevenueBottomUpMemo(int[] p, int n) {
        int[] memo = new int[n+1];
        memo[0] = 0;
        for(int i=1; i<=n; i++) {
            int maxRev = Integer.MIN_VALUE;
            for(int j=1; j<=i; j++) {
                maxRev = Math.max(maxRev, p[j-1] + memo[i-j]);
            }
            memo[i] = maxRev;
        }
        return memo[n];
    }

    public void run() {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(maxRevenueTopDownNonDynamicProgramming(p, 4));
        System.out.println(maxRevenueTopDownMemo(p, 4));
        System.out.println(maxRevenueBottomUpMemo(p, 4));
    }
    public static void main(String[] args) {
        new RodCutting().run();
    }
}