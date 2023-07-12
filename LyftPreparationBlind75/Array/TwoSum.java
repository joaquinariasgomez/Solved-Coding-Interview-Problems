import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] solution = new int[2];

        for(int i=0; i<nums.length; i++) {
            int remaining = target - nums[i];
            if(map.containsKey(remaining)) {
                solution[0] = i;
                solution[1] = map.get(remaining);
                return solution;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

    public void run() {
        int[] array = {2, 3, 11, 7};
        int sum = 9;
        int[] sol = twoSum(array, sum);
        System.out.println("Index 0: "+sol[0]+ " Index 1: "+sol[1]);
    }

    public static void main(String[] args) {
        new TwoSum().run();
    }
}