public class MaximumProductSubarray {

    public int getMaxProd(int[] nums) {
        int maxProd = nums[0];
        int currMaxProd = nums[0];
        int currMinProd = nums[0];

        for(int i=1; i<nums.length; i++) {
            int tmp = nums[i] * currMaxProd;
            currMaxProd = Math.max(nums[i]*currMinProd, Math.max(tmp, nums[i]));
            currMinProd = Math.min(nums[i]*currMinProd, Math.min(tmp, nums[i]));
            maxProd = Math.max(maxProd, currMaxProd);
        }

        return maxProd;
    }

    public void run() {
        int[] nums = {2,3,-2,4};
        System.out.println(getMaxProd(nums));
    }
    public static void main(String[] args) {
        new MaximumProductSubarray().run();
    }
}