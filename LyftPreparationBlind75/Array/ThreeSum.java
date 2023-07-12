import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        HashSet<List<Integer>> controlDuplicates = new HashSet<List<Integer>>();

        for(int i=0; i<nums.length; i++) {
            int obj = -nums[i]; // We want to find the sum o triplet that makes 0
            HashSet<Integer> set = new HashSet<Integer>();
            for(int j=i+1; j<nums.length; j++) {
                int remaining = obj - nums[j];
                if(set.contains(remaining)) {
                    // Return triplet <i, j, remaining>
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(remaining);
                    triplet.add(nums[j]);
                    Collections.sort(triplet);
                    if(!controlDuplicates.contains(triplet)) {
                        sol.add(triplet);
                        controlDuplicates.add(triplet);
                    }
                }
                else {
                    set.add(nums[j]);
                }
            }
        }

        return sol;
    }

    public void run() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> sol = threeSum(nums);
        for(int i=0; i<sol.size(); i++) {
            List<Integer> triplet = sol.get(i);
            System.out.println("Triplet: "+triplet.get(0)+" "+triplet.get(1)+" "+triplet.get(2));
        }
    }
    public static void main(String[] args) {
        new ThreeSum().run();
    }
}