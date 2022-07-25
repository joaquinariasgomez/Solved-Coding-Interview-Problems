public class SearchInRotatedArray {

    public int searchIndex(int[] nums, int n) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length-1;
        while(start<=end) { // This loop will set left pointer to the lowest element in array (also known as pivot)
            int mid = start + (end-start)/2;
            if(nums[mid] > nums[end]) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }

        int pivot = start;   // Pivot point
        start = 0;
        end = nums.length-1;

        if(n >= nums[pivot] && n <= nums[end]) {
            start = pivot;
        }
        else {
            end = pivot-1;
        }

        while(start<=end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == n) {
                return mid;
            }
            else if(nums[mid] < n) {
                start = mid+1;
            }
            else {
                end = mid-1;
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
