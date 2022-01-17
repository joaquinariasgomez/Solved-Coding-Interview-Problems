public class FindTargetIndicesAfterSortingArray {
    public int getMaxIndex(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        while(begin < end) {
            int mid = begin + (end-begin)/2;
            if(nums[mid] > target) {
                end = mid;
            }
            else {
                begin = mid + 1;
            }
        }
        if(nums[begin] == target) {
            return begin;
        }
        else {
            return begin-1;
        }
    }

    public int getMinIndex(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        while(begin < end) {
            int mid = begin + (end-begin)/2;
            if(nums[mid] < target) {
                begin = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return begin;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> sol = new ArrayList<Integer>();

        int minIndex = getMinIndex(nums, target);
        int maxIndex = getMaxIndex(nums, target);
        //System.out.println(minIndex);
        //System.out.println(maxIndex);

        for(int i=minIndex; i<=maxIndex; i++) {
            sol.add(i);
        }

        return sol;
    }
}
