import java.util.ArrayList;

public class CoinChange2 {

    public void minCoins(ArrayList<ArrayList<Integer>> selectedCoins, int[] coins, int c, int n) {
        if(n==0) {
            if(coins[n] > c) {
                return;
            }
            else {
                // Add to last set
                if(selectedCoins.size() == 0) {
                    ArrayList<Integer> newSet = new ArrayList<Integer>();
                    newSet.add(coins[n]);
                    selectedCoins.add(newSet);
                }
                else {
                    selectedCoins.get(0).add(coins[n]);
                }
                minCoins(selectedCoins, coins, c-coins[n], n);
            }
        }
        else {
            if(coins[n] > c) {
                minCoins(selectedCoins, coins, c, n-1);
            }
            else {
                // Either add to current set or create new set
                ArrayList<Integer> newSet = new ArrayList<Integer>();
                newSet.add(coins[n]);
                selectedCoins.add(newSet);
                minCoins(selectedCoins, coins, c-coins[n], n);
                minCoins(selectedCoins, coins, c, n-1);
            }
        }
    }

    public void run() {
        int[] coins = {1, 5, 10, 25};
        int c = 6;
        ArrayList<ArrayList<Integer>> selectedCoins = new ArrayList<ArrayList<Integer>>();
        minCoins(selectedCoins, coins, c, coins.length - 1);

        for(ArrayList<Integer> list:selectedCoins) {
            for(int e:list) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new CoinChange2().run();
    }
}
