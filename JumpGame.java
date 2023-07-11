public class JumpGame {

    public boolean isPossible(int[] nums) {
        int[] nCalls = {0};
        boolean sol = isPossibleRec(nums, 0, nCalls);
        System.out.println("Number of calls: "+nCalls[0]);
        return sol;
    }

    public boolean isPossibleRec(int[] nums, int index, int[] nCalls) {
        nCalls[0]++;
        if(nums[index] >= (nums.length-1 - index)) { // We have a number of jumps that can get us to the end
            return true;
        }
        if(nums[index] <= 0) {
            return false;
        }
        for(int i=1; i<=nums[index]; i++) {
            if(isPossibleRec(nums, index+i, nCalls)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPossibleMemo(int[] nums) {
        int[] nCalls = {0};
        int[] memo = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            memo[i] = -1;
        }
        boolean sol = isPossibleRecMemo(nums, 0, memo, nCalls);
        System.out.println("Number of calls: "+nCalls[0]);
        return sol;
    }

    public boolean isPossibleRecMemo(int[] nums, int index, int[] memo, int[] nCalls) {
        nCalls[0]++;
        if(nums[index] >= (nums.length-1 - index)) { // We have a number of jumps that can get us to the end
            return true;
        }
        if(nums[index] <= 0) {
            return false;
        }
        if(memo[index] != -1) {
            return memo[index] > 0;
        }
        for(int i=1; i<=nums[index]; i++) {
            if(isPossibleRecMemo(nums, index+i, memo, nCalls)) {
                memo[index] = 1;
                return memo[index] > 0;
            }
        }
        memo[index] = 0;
        return memo[index] > 0;
    }

    public void run() {
        // int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};// -> This is false
        System.out.println(isPossible(nums));
        System.out.println(isPossibleMemo(nums));
    }
    public static void main(String[] args) {
        new JumpGame().run();
    }
}