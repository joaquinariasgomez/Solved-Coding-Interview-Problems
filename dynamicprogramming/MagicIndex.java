public class MagicIndex {

    public int binarySearch(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int midP = start + (end - start)/2;
            if(nums[midP] == midP) {
                return midP;
            }
            else {
                if(nums[midP] > midP) {
                    end = midP - 1;
                }
                else {
                    start = midP + 1;
                }
            }
        }
        return -1;
    }

    public void run() {
        int[] nums = {-1, 1, 4, 5, 8};  // Sorted nums
        System.out.println(binarySearch(nums));
    }
    public static void main(String[] args) {
        new MagicIndex().run();
    }
}
