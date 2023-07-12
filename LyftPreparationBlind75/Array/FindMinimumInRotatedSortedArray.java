public class FindMinimumInRotatedSortedArray {

    public int getSol(int[] nums) {
        int begin = 0;
        int end = nums.length-1;

        while(begin < end) {
            int mid = begin + (end-begin)/2;
            if(nums[mid] < nums[end]) {
                end = mid;
            }
            else {
                begin = mid+1;
            }
        }
        return nums[begin];
    }

    public void run() {
        int[] nums = {3,4,5,1,2};
        int sol = getSol(nums);
        System.out.println(sol);
    }
    public static void main(String[] args) {
        new FindMinimumInRotatedSortedArray().run();
    }
}