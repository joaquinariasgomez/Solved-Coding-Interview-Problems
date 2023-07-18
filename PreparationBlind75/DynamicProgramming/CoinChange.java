import java.util.Arrays;

public class CoinChange {

    public int GreedyDoesNotWork(int[] coins, int amount) { // Greedy, does not work
        int count = 0;
        Arrays.sort(coins);
        for(int i=coins.length-1; i>=0; i--) {
            if((amount / coins[i]) != 0) {
                count += amount / coins[i];
                amount = amount % coins[i];
            }
        }
        if(amount > 0) return -1;
        return count;
    }

    public int minCoins(int[] coins, int amount) {
        return minCoinsTopDown(coins, amount, new int[amount+1]);
    }

    public int minCoinsBottomUp(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        for(int i=0; i<memo.length; i++) memo[i] = Integer.MAX_VALUE;
        memo[0] = 0;
        for(int i=1; i<=amount; i++) {
            for(int coin : coins) {
                if(i - coin >= 0) {
                    memo[i] = Math.min(memo[i], 1+memo[i-coin]);
                }
            }
        }

        if(memo[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return memo[amount];
        }
    }

    public int minCoinsTopDown(int[] coins, int amount, int[] memo) {
        if(amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return 0;
        }
        if(memo[amount] != 0) return memo[amount];
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int tempRes = minCoinsTopDown(coins, amount-coin, memo);
            if(tempRes !=-1 && tempRes < min) {
                min = 1 + tempRes;
            }
        }
        memo[amount] = (min==Integer.MAX_VALUE) ? -1:min;
        return memo[amount];
    }

    public void run() {
        int[] coins = {186,419,83,408};
        int n = 6249;
        // int[] coins = {1, 2, 5};
        // int n = 11;
        System.out.println(minCoinsBottomUp(coins, n));
    }
    public static void main(String[] args) {
        new CoinChange().run();
    }
}