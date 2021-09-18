public class HouseRobber {

    public int getMaxProfit(int[] houses, boolean[] visited, int currentHouse) {
        if(currentHouse == 0) {
            if(visited[currentHouse]) {
                return 0;
            }
            else {
                return houses[0];
            }
        }
        if(visited[currentHouse]) {
            return getMaxProfit(houses, visited, currentHouse-1);
        }
        else {
            visited[currentHouse-1] = true;
            int profit1 = houses[currentHouse] + getMaxProfit(houses, visited, currentHouse-1);
            visited[currentHouse-1] = false;
            int profit2 = getMaxProfit(houses, visited, currentHouse-1);
            return Math.max(profit1, profit2);
        }
    }

    public int maxProfitDynamic(int[] houses) {
        int[] memo = new int[houses.length];
        memo[0] = houses[0];
        memo[1] = Math.max(houses[0], houses[1]);

        for(int i=2; i<houses.length; i++) {
            memo[i] = Math.max(memo[i-1], memo[i-2]+houses[i]);
        }
        return memo[houses.length-1];
    }

    public int maxProfit(int[] houses) {
        boolean[] visited = new boolean[houses.length];
        return getMaxProfit(houses, visited, houses.length-1);
    }

    public void run() {
        int[] houses = {1, 2, 3, 1};
        //int[] houses = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160};
        System.out.println(maxProfitDynamic(houses));
    }
    public static void main(String[] args) {
        new HouseRobber().run();
    }
}
