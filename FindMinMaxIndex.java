public class FindMinMaxIndex {
    public int findMin(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        int result = -1;
        while(first <= last) {
            int mid = (last + first) / 2;
            if(target < nums[mid]) {
                last = mid - 1;
            }
            else {
                if(target > nums[mid]) {
                    first = mid + 1;
                }
                else {
                    result = mid;
                    last = mid - 1;
                }
            }
        }
        return result;
    } 
    
    public int findMax(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        int result = -1;
        while(first <= last) {
            int mid = (last + first) / 2;
            if(target < nums[mid]) {
                last = mid - 1;
            }
            else {
                if(target > nums[mid]) {
                    first = mid + 1;
                }
                else {
                    result = mid;
                    first = mid + 1;
                }
            }
        }
        return result;
    }
    
    public static int[] searchRange(int[] nums, int target) {
        int[] solution = new int[2];
        solution[0] = findMin(nums, target);
        solution[1] = findMax(nums, target);
        return solution;
    }

    public static void main(String[] args) {
        int[] solution = searchRange({1, 2, 3, 3, 3, 4, 5}, 3);
    }
}