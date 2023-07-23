public class JumpGame {

    public boolean canJumpRec(int[] nums, int currPos, int[] memo) {
        if(currPos >= nums.length) return false;
        if(currPos == nums.length-1) return true;
        if(memo[currPos] != -1) {
            if(memo[currPos] == 1) return true;
            else return false;
        }
        int currMaxJump = nums[currPos];
        for(int i=1; i<=currMaxJump; i++) {
            if(canJumpRec(nums, currPos+i, memo)) {
                memo[currPos] = 1;
                return true;
            }
        }
        memo[currPos] = 0;
        return false;
    }

    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        for(int i=0; i<memo.length; i++) {
            memo[i] = -1;
        }
        return canJumpRec(nums, 0, memo);
    }

    public void run() {
        int[] nums = {2,3,1,1,4};
        // int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public static void main(String[] args) {
        new JumpGame().run();
    }
}