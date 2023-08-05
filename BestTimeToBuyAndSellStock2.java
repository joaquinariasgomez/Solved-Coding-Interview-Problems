public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] values) {
        if(values.length < 2) return 0;
        // Strategy is to always buy on local mins and always sell on local maxs, so ensure that we get profit
        int currMax = 0;
        for(int i=0; i<values.length-1; i++) {
            if(values[i] < values[i+1]) {
                currMax += values[i+1] - values[i];
            }
        }
        return currMax;
    }

    public void run() {
        int[] values = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(values));
    }
    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock2().run();
    }
}