public class CoinChange {

    public int minCoins(int[] coins, int c, int n) {
        if(n==0) {
            if(coins[n] > c) {
                return 0;
            }
            else {
                return 1 + minCoins(coins, c-coins[n], n);
            }
        }
        else {
            if(coins[n] > c) {
                return minCoins(coins, c, n-1);
            }
            else {
                return Math.min(1 + minCoins(coins, c-coins[n], n), minCoins(coins, c, n-1));
            }
        }
    }

    public int iterativeMinCoins(int[] coins, int c) {  // Dynamic programming solution
        int n = coins.length;
        int[][] solutions = new int[n][c+1];

        for(int i=0; i<n; i++) {
            for(int j=0; j<=c; j++) {
                if(i==0) {
                    if(coins[i] <= j) {
                        solutions[i][j] = 1 + solutions[i][j-coins[i]];
                    }
                    else {
                        solutions[i][j] = 0;
                    }
                }
                else {
                    if(coins[i] <= j) {
                        solutions[i][j] = Math.min(solutions[i-1][j], 1 + solutions[i][j-coins[i]]);
                    }
                    else {
                        solutions[i][j] = solutions[i-1][j];
                    }
                }
            }
        }
        return solutions[n-1][c];
    }

    public void run() {
        // int[] coins = {1, 5, 10, 25};
        int[] coins = {186,419,83,408};
        int c = 6249;
        System.out.println(iterativeMinCoins(coins, c));
        System.out.println(minCoins(coins, c, coins.length - 1));
    }
    public static void main(String[] args) {
        new CoinChange().run();
    }
}
