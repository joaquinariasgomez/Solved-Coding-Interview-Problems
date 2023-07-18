public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxP = 0;

        for(int i=0; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxP = Math.max(prices[i] - min, maxP);
        }

        return maxP;
    }

    public void run() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock().run();
    }
}