import java.util.List;
import java.util.ArrayList;

public class Permutations {

    public List<List<Integer>> getPermutations(int[] nums) {
        List<Integer> originNums = new ArrayList<Integer>();
        for (int num : nums) {
            originNums.add(num);
        }

        List<List<Integer>> perms = getPerms(originNums);
        return perms;
    }

    public List<List<Integer>> getPerms(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.size() == 1) {
            result.add(new ArrayList<Integer>(nums));
            return result;
        }

        for (int i = 0; i < nums.size(); i++) {
            int n = nums.remove(0);
            List<List<Integer>> perms = getPerms(nums);
            for (List<Integer> perm : perms) {
                perm.add(n);
                result.add(perm);
            }
            nums.add(n);
        }
        return result;
    }

    public void run() {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> sol = getPermutations(nums);
        System.out.println(sol);
    }

    public static void main(String[] args) {
        new Permutations().run();
    }
}