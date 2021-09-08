import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

public class ThreeSum {

    public List<List<Integer>> twoSum(int[] array, int sum) {
        List<List<Integer>> solution = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i=0; i<array.length; i++) {
            int compliment = sum - array[i];
            if(hashSet.contains(compliment)) {
                solution.add(Arrays.asList(compliment, array[i]));
            }
            hashSet.add(array[i]);
        }
        return solution;
    }

    public List<List<Integer>> getSums(int[] nums) {
        List<List<Integer>> solution = new LinkedList();
        HashSet<List<Integer>> controlDuplicates = new HashSet<List<Integer>>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            // Searching for a num that equals 0 - nums[i]
            int left = -nums[i];
            HashSet<Integer> set = new HashSet<Integer>();
            for(int j=i+1; j<nums.length; j++) {
                if(set.isEmpty()) {
                    set.add(nums[j]);
                }
                else {
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
        }
        return solution;
    }

    public void run() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = twoSum(nums, 0);
        for(List<Integer> list:lists) {
            for(int e:list) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new ThreeSum().run();
    }
}
