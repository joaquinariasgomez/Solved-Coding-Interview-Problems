import java.util.Random;

public class ShuffleSort {
    public int[] exch(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
        return nums;
    }

    public int[] KnuthShuffle(int[] nums) {
        Random random = new Random();
        for(int i=0; i<nums.length; i++) {
            int r = random.nextInt(i+1); // Value between 0 and i(inclusive)
            nums = exch(nums, i, r);
        }
        return nums;
    }

    public void run() {
        int[] nums = {5, 4, 3, 1, 2};
        int[] sorted = KnuthShuffle(nums);
        for(int e : sorted) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new ShuffleSort().run();
    }
}
