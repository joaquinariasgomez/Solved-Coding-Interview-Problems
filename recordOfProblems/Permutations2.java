import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

    public void run() {
        int[] nums = { 1, 2 };
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> currentPerm = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        fillPermutations(sol, nums, currentPerm, used);
        System.out.println(sol);
        System.out.println(currentPerm);
    }

    public void fillPermutations(List<List<Integer>> sol, int[] nums, List<Integer> currentPerm, boolean[] used) {
        if (currentPerm.size() == nums.length) {
            sol.add(new ArrayList<Integer>(currentPerm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                currentPerm.add(nums[i]);
                used[i] = true;
                fillPermutations(sol, nums, currentPerm, used);
                currentPerm.remove(0);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        new Permutations2().run();
    }
}