public class BinarySearch2 {

    public int findPosition(int[] nums, int n) {
        int start = 0;
        int end = nums.length-1;
        int position = -1;
        while(start <= end) {
            int midP = start + (end - start)/2;
            if(nums[midP] == n) {
                return midP;
            }
            else {
                if(nums[midP] > n) {
                    end = midP - 1;
                }
                else {
                    start = midP + 1;
                position = midP;
                }
            }
        }
        return position;
    }

    public void run() {
        int[] nums = {1, 3, 4, 6, 6, 12, 15};
        int n = 10;
        // Is should tell us where do we insert n, if we dont find it
        System.out.println(findPosition(nums, n));
    }
    public static void main(String[] args) {
        new BinarySearch2().run();
    }
}
