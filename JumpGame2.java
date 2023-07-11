public class JumpGame2 {

    public int minJumps(int[] nums) {
        int[] nCalls = {0};
        int sol = minJumpsRec(nums, 0, Integer.MAX_VALUE, nCalls);
        System.out.println("N calls: "+nCalls[0]);
        return sol;
    }

    public int minJumpsRec(int[] nums, int index, int minJumps, int[] nCalls) {   // NO DP
        nCalls[0]++;
        if(index >= nums.length-1) {
            return 0;
        }
        if(nums[index] == 0) return 999;
        for(int i=1; i<=nums[index]; i++) {
            int nJumps = 1 + minJumpsRec(nums, index+i, minJumps, nCalls);
            minJumps = Math.min(nJumps, minJumps);
        }
        return minJumps;
    }

    public int minJumpsMemo(int[] nums) {
        int[] nCalls = {0};
        int[] memo = new int[nums.length];
        for(int i=0; i<memo.length; i++) {
            memo[i] = -1;
        }
        int sol = minJumpsRecMemo(nums, 0, Integer.MAX_VALUE, memo, nCalls);
        System.out.println("N calls: "+nCalls[0]);
        return sol;
    }

    public int minJumpsRecMemo(int[] nums, int index, int minJumps, int[] memo, int[] nCalls) {   // NO DP
        nCalls[0]++;
        if(index >= nums.length-1) {
            return 0;
        }
        if(nums[index] == 0) return 999;
        if(memo[index] != -1) {
            return memo[index];
        }
        for(int i=1; i<=nums[index]; i++) {
            int nJumps = 1 + minJumpsRecMemo(nums, index+i, minJumps, memo, nCalls);
            minJumps = Math.min(nJumps, minJumps);
        }
        memo[index] = minJumps;
        return memo[index];
    }

    public void run() {
        int[] nums = {2,3,1,1,4};
        // int[] nums = {2,3,0,1,4};
        System.out.println(minJumps(nums));
        System.out.println(minJumpsMemo(nums));
    }

    public static void main(String[] args) {
        new JumpGame2().run();
    }
}