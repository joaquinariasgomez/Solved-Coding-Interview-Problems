public class FindMinimumInRotatedSortedArray {

    public int minimum(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int start=0;
        int end=nums.length-1;
        while(start<end) {
            int mid = start +(end-start)/2;
            if(nums[mid]>nums[end]) {
                start=mid+1;
            }
            else {
                end=mid;
            }
        }
        return nums[start];
    }

    public void run() {
        int[] nums = {3,4,5,1,2};
        System.out.println(minimum(nums));
    }
    public static void main(String[] args) {
        new FindMinimumInRotatedSortedArray().run();
    }
}
