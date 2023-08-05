public class SearchInRotatedArray {

    public int searchIndex(int[] nums, int n) {
        int begin = 0;
        int end = nums.length-1;
        while(begin < end) {
            int mid = begin + (end-begin)/2;
            if(nums[mid] > nums[end]) {
                begin = mid+1;
            }
            else {
                end = mid;
            }
        }
        int pivot = begin;
        if(target >= nums[pivot] && target <= nums[nums.length-1]) {    //Right part of array
            begin = pivot;
            end = nums.length-1;
        }
        else {  // Left part of array
            begin = 0;
            end = pivot-1;
        }
        while(begin <= end) {
            int mid = begin + (end-begin)/2;
            if(nums[mid] > target) {
                end = mid-1;
            }
            else {
                if(nums[mid] < target) {
                    begin = mid+1;
                }
                else {
                    return mid;
                }
            }
        }
        return -1;
    }

    public void run() {
        int[] nums = {5,1,3};
        int n = 1;
        System.out.println(searchIndex(nums, n));
    }
    public static void main(String[] args) {
        new SearchInRotatedArray().run();
    }
}
