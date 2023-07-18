public class HouseRobber {

    public int maxAmountRec(int[] nums, int currHouse, int[] memo) {
        if (currHouse >= nums.length)
            return 0;
        if(memo[currHouse] != -1) return memo[currHouse];
        int valueRobbing = nums[currHouse] + maxAmountRec(nums, currHouse+2, memo);
        int valueWithoutRobbing = maxAmountRec(nums, currHouse+1, memo);
        memo[currHouse] = Math.max(valueRobbing, valueWithoutRobbing);
        return memo[currHouse];
    }

    public int maxAmount(int[] nums) {
        int[] memo = new int[nums.length];
        for(int i=0; i<memo.length; i++) memo[i] = -1;
        return maxAmountRec(nums, 0, memo);
    }

    public void run() {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(maxAmount(nums));
    }

    public static void main(String[] args) {
        new HouseRobber().run();
    }
}