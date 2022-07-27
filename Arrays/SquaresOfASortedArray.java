class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sol = new int[nums.length];
        if(nums.length == 1) {
            sol[0] = nums[0]*nums[0];
            return sol;
        }
        
        for(int i=0; i<nums.length; i++) {
            nums[i] *= nums[i];
        }
        
        int prev=nums[0];
        int a=1;
        while(nums[a] <= prev && a < nums.length-1) {
            prev = nums[a];
            a++;
        }
        
        // Now nums[a] is the center point in the sorted squared vector
        int left = a-1;
        int right = a;
        int writer = 0;
        
        while(left >= 0 || right < nums.length) {
            if(left < 0) {
                sol[writer++] = nums[right++];
            }
            else if(right >= nums.length) {
                sol[writer++] = nums[left--];
            }
            else {
                if(nums[left] < nums[right]) {
                    sol[writer++] = nums[left--];
                }
                else {
                    sol[writer++] = nums[right++];
                }
            }
            
        }
        
        return sol;
    }
}
