import java.util.*;

public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        boolean canBuy = true; // canBuy state or not canBuy state
        HashMap<String, Integer> memo = new HashMap<String, Integer>();
        return maxProfitRec(prices, canBuy, 0, memo);
    }

    public int maxProfitRec(int[] prices, boolean canBuy, int idx, HashMap<String, Integer> memo) {
        if(idx >= prices.length) return 0;
        String key = idx+"-"+canBuy;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int cooldown = maxProfitRec(prices, canBuy, idx+1, memo);
        if(canBuy) {
            int buy = maxProfitRec(prices, !canBuy, idx+1, memo) - prices[idx];
            memo.put(key, Math.max(buy, cooldown));
        }
        else {
            int sell = maxProfitRec(prices, !canBuy, idx+2, memo) + prices[idx];
            memo.put(key, Math.max(sell, cooldown));
        }
        return memo.get(key);
    }

    public void run() {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    } 
    public static void main(String[] args) {
        new BestTimeToBuyAndSellStockWithCooldown().run();
    }
}