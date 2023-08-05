public class LonelyNumber {

    public int getLonely(int[] nums) {
        int sol = nums[0];
        for(int i=1; i<nums.length; i++) {
            sol ^= nums[i]; //XOR to nullify same numbers
        }
        return sol;
    }

    public void run() {
        // Find the only number that appears ONCE in the array
        int[] nums = {4, 4, 6, 1, 3, 1, 3};
        System.out.println(getLonely(nums));
    }
    public static void main(String[] args) {
        new LonelyNumber().run();
    }
}