public class HouseRobber2 {

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] firstNums = new int[nums.length-1];
        int[] lastNums = new int[nums.length-1];

        for(int i=0; i<nums.length-1; i++) firstNums[i] = nums[i];
        for(int i=1; i<nums.length; i++) lastNums[i-1] = nums[i];

        int[] memo = new int[nums.length];
        for(int i=0; i<memo.length; i++) memo[i] = -1;
        int maxRobFirst = robRec(firstNums, 0, memo);
        for(int i=0; i<memo.length; i++) memo[i] = -1;
        int maxRobLast = robRec(lastNums, 0, memo);
        return Math.max(maxRobFirst, maxRobLast);
    }

    public int robRec(int[] nums, int currHouse, int[] memo) {
        if(currHouse >= nums.length) return 0;
        if(memo[currHouse] != -1) return memo[currHouse];
        int valueWithoutRobbing = robRec(nums, currHouse+1, memo);
        int valueWithRobbing = nums[currHouse] + robRec(nums, currHouse+2, memo);
        memo[currHouse] = Math.max(valueWithoutRobbing, valueWithRobbing);
        return memo[currHouse];
    }

    public void run() {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(rob(nums));
    }

    public static void main(String[] args) {
        new HouseRobber().run();
    }
}