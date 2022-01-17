public class BinarySearch {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;

        while(begin<=end) {
            int mid = begin + (end-begin)/2;
            if(nums[mid]>target) {
                end = mid-1;
            }
            else if (nums[mid]<target){
                begin = mid+1;
            }
            else {
                return mid;
            }
        }

        return -1;
    }
}
