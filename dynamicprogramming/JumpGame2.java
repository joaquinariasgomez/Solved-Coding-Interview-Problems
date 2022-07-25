public class JumpGame2 {

    public int minJumps(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0; i<dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<i; j++) {
                if(i-j <= nums[j] && dp[i] > dp[j] + 1) {
                    dp[i] = dp[j]+1;
                } 
            }
        }


        return dp[nums.length-1];
    }

    public void run() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(minJumps(nums));
    }
    public static void main(String[] args) {
        new JumpGame2().run();
    }
}
