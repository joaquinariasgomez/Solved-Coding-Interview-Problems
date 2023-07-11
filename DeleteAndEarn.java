import java.util.List;
import java.util.ArrayList;

public class DeleteAndEarn {

    public int maxPoints(int[] nums) {
        List<Integer> numsArray = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++) {
            numsArray.add(nums[i]);
        }
        return maxPointsRec(numsArray);
    }

    public int maxPointsRec(List<Integer> nums) {
        if(nums.size() == 0) {
            return 0;
        }
        for(int i=0; i<nums.size(); i++) {
            int currentInt = nums.get(i);
            for(int j=0; j<nums.size(); j++) {
                if(nums.get(j) == currentInt-1 || nums.get(j) == currentInt+1) {
                    nums.remove(j);
                }
            }
            return currentInt + maxPointsRec(nums);
        }
    }

    public void run() {
        int[] nums = {3, 4, 2};
        System.out.println(maxPoints(nums));
    }
    public static void main(String[] args) {
        new DeleteAndEarn().run();
    }
}