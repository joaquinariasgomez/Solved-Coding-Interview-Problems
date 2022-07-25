import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

public class ThreeSum {

    public void run() {
        List<List<Integer>> solution = new LinkedList();
        HashSet<List<Integer>> controlDuplicates = new HashSet<List<Integer>>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            // Searching for a num that equals 0 - nums[i]
            int left = -nums[i];
            HashSet<Integer> set = new HashSet<Integer>();
            for(int j=i+1; j<nums.length; j++) {
                // Check if set contains 
                int compliment = left - nums[j];
                if(set.contains(compliment)) {
                    List<Integer> posibleSolution = Arrays.asList(nums[i], compliment, nums[j]);
                    if(!controlDuplicates.contains(posibleSolution)) {
                        solution.add(posibleSolution);
                        controlDuplicates.add(posibleSolution);
                    }
                }
                else {
                    set.add(nums[j]);
                }
            }
        }
        return solution;
    }
    public static void main(String[] args) {
        new ThreeSum().run();
    }
}
