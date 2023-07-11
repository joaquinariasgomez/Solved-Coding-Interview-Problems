public class HouseRobber2 {
    public int solution(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] numsFirst = new int[nums.length-1];
        int[] numsLast = new int[nums.length-1];
        for(int i=0; i<nums.length-1; i++) {
            numsFirst[i] = nums[i];
        }
        for(int i=1; i<nums.length; i++) {
            numsLast[i-1] = nums[i];
        }
        // Solve two problems, with numsFirst and with numsLast and return max value
        return Math.max(robSub(numsFirst), robSub(numsLast));
    }

    public int robSub(int[] nums) {
        int[] memo = new int[nums.length];
        for(int i=0; i<memo.length; i++) {
            memo[i] = -1;
        }
        return robRecMemo(nums, 0, memo);
    }

    public int robRecMemo(int[] nums, int n, int[] memo) {
        if(n > nums.length-1) {
            return 0;
        }
        if(n == nums.length-1) {
            memo[n] = nums[n];
            return memo[n];
        }
        if(memo[n] != -1) {
            return memo[n];
        }
        int maxWithRob = nums[n] + robRecMemo(nums, n+2, memo);
        int maxWithoutRob = robRecMemo(nums, n+1, memo);
        memo[n] = Math.max(maxWithRob, maxWithoutRob);
        return memo[n];
    }
}