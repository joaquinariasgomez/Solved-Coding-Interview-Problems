public class LonelyNumber2 {

    public int getLonely(int[] nums) {
        int sol = 0;
        for(int i=0; i<32; i++) {
            int sum = 0;
            for(int num : nums) {
                sum += (num >> i) & 1;
            }
            sol |= (sum % 3) << i;
        }
        return sol;
    }

    public void run() {
        int[] nums = {2, 3, 2, 2, 4, 4, 4, 5, 5, 5};
        System.out.println(getLonely(nums));
    }
    public static void main(String[] args) {
        new LonelyNumber2().run();
    }
}