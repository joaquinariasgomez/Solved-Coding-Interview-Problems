public class CombinationSum4 {

    public int nWaysToSumRec(int[] nums, int target, int acumulatedNumber, int[] memo) {
        if (acumulatedNumber > target)
            return 0;
        if (acumulatedNumber == target)
            return 1;
        else {
            if(memo[acumulatedNumber] != -1) return memo[acumulatedNumber];
            int currentWays = 0;
            for (int i = 0; i < nums.length; i++) {
                currentWays += nWaysToSumRec(nums, target, acumulatedNumber+nums[i], memo);
            }
            memo[acumulatedNumber] = currentWays;
            return currentWays;
        }
    }

    public int nWaysToSum(int[] nums, int target) {
        int[] memo = new int[target];
        for(int i=0; i<memo.length; i++) memo[i] = -1;
        return nWaysToSumRec(nums, target, 0, memo);
    }

    public void run() {
        int[] nums = { 1, 2, 3 };
        int target = 4;
        System.out.println(nWaysToSum(nums, target));
    }

    public static void main(String[] args) {
        new CombinationSum4().run();
    }
}