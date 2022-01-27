package recordOfProblems;

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

    public int searchLeftMost(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;

        while(begin < end) {
            int mid = begin + (end-begin)/2;
            if(nums[mid] < target) {
                begin = mid+1;
            }
            else {
                end = mid;
            }
        }
        return begin;
    }

    public int searchRightMost(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;

        while(begin < end) {
            int mid = begin + (end-begin)/2;
            if(nums[mid] > target) {
                end = mid;
            }
            else {
                begin = mid + 1;
            }
        }
        return end - 1;
    }

    public void run() {
        int[] nums = {1, 2, 2, 2, 5, 6};
        System.out.println(searchRightMost(nums, 2));
    }

    public static void main(String[] args) {
        new BinarySearch().run();
    }
}
