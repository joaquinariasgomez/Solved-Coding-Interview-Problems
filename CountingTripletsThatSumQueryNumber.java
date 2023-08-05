import java.util.HashSet;

public class CountingTripletsThatSumQueryNumber {

    public int findTriplets(int[] nums, int k) {
        int sol = 0;
        for (int i = 0; i < nums.length; i++) {
            int obj = k - nums[i];
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j = i+1; j < nums.length; j++) {
                int remaining = obj - nums[j];
                if (set.contains(remaining)) {
                    sol++;
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return sol;
    }

    public void run() {
        int[] nums = { 1, 1, 1, 2, 2 };
        int k = 3;
        System.out.println(findTriplets(nums, k));
    }

    public static void main(String[] args) {
        new CountingTripletsThatSumQueryNumber().run();
    }
}