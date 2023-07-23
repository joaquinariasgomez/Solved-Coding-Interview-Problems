public class SearchInRotatedSortedArray {

    public int getSol(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;

        // Find pivot
        while(begin < end) {
            int mid = begin + (end-begin)/2;
            if(nums[mid] < nums[end]) {
                end = mid;
            }
            else {
                begin = mid+1;
            }
        }

        int pivot = begin;
        begin = 0;
        end = nums.length-1;
        if(target >= nums[pivot] && target <= nums[end]) {
            begin = pivot;
        }
        else {
            end = pivot-1;
        }
        while(begin <= end) {
            int mid = begin + (end-begin)/2;
            if(nums[mid] < target) {
                begin = mid+1;
            }
            else {
                if(nums[mid] > target) {
                    end = mid-1;
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }

    public void run() {
        // int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {1, 3};
        int sol = getSol(nums, 3);
        System.out.println(sol);
    }
    public static void main(String[] args) {
        new SearchInRotatedSortedArray().run();
    }
}