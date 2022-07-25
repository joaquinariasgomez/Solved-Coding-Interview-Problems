class Solution {
    public int searchInsert(int[] nums, int target) {
        int beg = 0;
        int end = nums.length-1;
        int position = -1;
        
        while(beg <= end) {
            int mid = beg + (end-beg)/2;

            if(nums[mid] < target) {
                position = mid+1;
                beg = mid+1;
            }
            else if(nums[mid] > target) {
                position = mid;
                end = mid-1;
            }
            else {
                return mid;
            }
        }
        
        return position;
    }
}
