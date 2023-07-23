import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int getLongest(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums) set.add(num);
        int maxSeq = 0;

        for(int i=0; i<nums.length; i++) {
            // If this number has a left neighbour, we can increase maxSeq
            if(!set.contains(nums[i]-1)) {
                int length = 0;
                while(set.contains(nums[i]+length)) {
                    length++;
                }
                maxSeq = Math.max(maxSeq, length);
            }
            System.out.println("Para "+nums[i]+" cuento "+maxSeq);
        }

        return maxSeq;
    }

    public void run() {
        // int[] nums = {100,4,200,1,3,2};
        int[] nums = {0,0,-1};
        System.out.println(getLongest(nums));
    }
    public static void main(String[] args) {
        new LongestConsecutiveSequence().run();
    }
}