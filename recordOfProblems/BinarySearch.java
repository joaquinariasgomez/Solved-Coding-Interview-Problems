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
            if(target <= nums[mid]) {
                end = mid;
            }
            else {
                begin = mid+1;
            }
        }
        return begin;
    }

    public int searchLeftMostV2(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        int res = -1;
        while(begin <= end) {
            int mid = begin + (end-begin)/2;
            if(target < nums[mid]) {
                end = mid-1;
            }
            else {
                if(target > nums[mid]) {
                    begin = mid+1;
                }
                else {
                    res = mid;
                    end = mid-1;
                }
            }
        }
        return res;
    }

    public int searchRightMost(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;

        while(begin < end) {
            int mid = begin + (end-begin)/2;
            if(target < nums[mid]) {
                end = mid;
            }
            else {
                begin = mid + 1;
            }
        }
        return end - 1;
    }

    public int searchRightMostV2(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        int res = -1;
        while(begin <= end) {
            int mid = begin + (end-begin)/2;
            if(target < nums[mid]) {
                end = mid-1;
            }
            else {
                if(target > nums[mid]) {
                    begin = mid+1;
                }
                else {
                    res = mid;
                    begin = mid+1;
                }
            }
        }
        return res;
    }

    public void run() {
        int[] nums = {1, 2, 2, 2, 5, 6};
        System.out.println(searchRightMostV2(nums, 2));
    }

    public static void main(String[] args) {
        new BinarySearch().run();
    }
}
