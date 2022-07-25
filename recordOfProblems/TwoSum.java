public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();    //{Element, Index}
        int[] solution = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            int remaining = target - nums[i];
            
            if(map.containsKey(remaining)) {
                solution[0] = map.get(remaining);
                solution[1] = i;
            }
            else {
                map.put(nums[i], i);
            }
        }
        
        return solution;
    }
}