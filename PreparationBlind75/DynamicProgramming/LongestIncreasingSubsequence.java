public class LongestIncreasingSubsequence {

    public int longestBottomUp(int[] nums) {
        int[] memo = new int[nums.length];
        for(int i=0; i<memo.length; i++) memo[i] = 1;
        int maxValue = memo[0];

        for(int i=nums.length-2; i>=0; i--) {
            for(int cand = i+1; cand < nums.length; cand++) {
                if(nums[i] < nums[cand]) {
                    memo[i] = Math.max(1+memo[cand], memo[i]);
                    maxValue = Math.max(maxValue, memo[i]);
                }
            }
        }
        return maxValue;
    }

    public void run() {
        int[] nums = {10,9,2,5,3,7,101,18};
        // int[] nums = {1, 2, 4, 3};
        System.out.println(longestBottomUp(nums));
    }
    public static void main(String[] args) {
        new LongestIncreasingSubsequence().run();
    }
}