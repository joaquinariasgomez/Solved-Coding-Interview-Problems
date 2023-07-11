public class HouseRobber {

    public int getMaxMoney(int[] houses) {
        int[] nCalls = {0};
        int sol = getMaxMoneyRec(houses, 0, nCalls);
        System.out.println("Number of recursive calls: "+nCalls[0]);
        return sol;
    }

    public int getMaxMoneyRec(int[] houses, int n, int[] nCalls) {
        nCalls[0]++;
        if (n > houses.length - 1) {
            return 0;
        }
        if (n == houses.length - 1) {
            return houses[n];
        }
        // We can do two things. Either rob current house and jump two houses or skip
        // current house and jump to next house
        int robCurrent = houses[n] + getMaxMoneyRec(houses, n + 2, nCalls);
        int skipCurrent = getMaxMoneyRec(houses, n + 1, nCalls);
        return Math.max(robCurrent, skipCurrent);
    }

    public int getMaxMoneyMemo(int[] houses) {
        int[] nCalls = {0};
        int[] memo = new int[houses.length];
        for(int i=0; i<memo.length; i++) {
            memo[i] = -1;
        }
        int sol = getMaxMoneyRecMemo(houses, 0, memo, nCalls);
        System.out.println("Number of recursive calls: "+nCalls[0]);
        return sol;
    }

    public int getMaxMoneyRecMemo(int[] houses, int n, int[] memo, int[] nCalls) {
        nCalls[0]++;
        if (n > houses.length - 1) {
            return 0;
        }
        if (n == houses.length - 1) {
            memo[n] = houses[n];
            return memo[n];
        }
        if(memo[n] != -1) {
            return memo[n];
        }
        // We can do two things. Either rob current house and jump two houses or skip
        // current house and jump to next house
        int robCurrent = houses[n] + getMaxMoneyRecMemo(houses, n + 2, memo, nCalls);
        int skipCurrent = getMaxMoneyRecMemo(houses, n + 1, memo, nCalls);
        memo[n] = Math.max(robCurrent, skipCurrent);
        return memo[n];
    }

    public void run() {
        int[] houses = { 1, 2, 3, 1 };
        System.out.println(getMaxMoney(houses));
        System.out.println(getMaxMoneyMemo(houses));
    }

    public static void main(String[] args) {
        new HouseRobber().run();
    }
}