import java.util.HashSet;

public class MissingNumber {

    public int solExtraMemory(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int a : nums) {
            set.add(a);
        }

        for(int i=0; i<=nums.length; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public int solBitOperation(int[] nums) {
        int[] extended = new int[nums.length+1];
        int finalXor = 0;

        for(int i=0; i<nums.length; i++) {
            finalXor = finalXor ^ nums[i];
        }
        for(int i=0; i<extended.length; i++) {
            extended[i] = i;
            finalXor = finalXor ^ extended[i];
        }
        
        return finalXor;
    }

    public void run() {
        int[] nums = {3, 0, 1};
        System.out.println(solBitOperation(nums));
    }
    public static void main(String[] args) {
        new MissingNumber().run();
    }
}