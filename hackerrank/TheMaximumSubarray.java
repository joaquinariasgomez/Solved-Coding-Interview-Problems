import java.util.Arrays;
import java.util.List;

public class TheMaximumSubarray {

    public List<Integer> maxSubarray(List<Integer> arr) {
        int maxSubarray = arr.get(0);
        int currentSubArray = arr.get(0);
        int maxSubsequence = arr.get(0);
        for(int i=1; i<arr.size(); i++) {
            currentSubArray = Math.max(arr.get(i), currentSubArray+arr.get(i));
            maxSubarray = Math.max(maxSubarray, currentSubArray);
            maxSubsequence = Math.max(maxSubsequence, Math.max(arr.get(i), maxSubsequence+arr.get(i)));
        }

        return Arrays.asList(maxSubarray, maxSubsequence);
    }

    public void run() {
        List<Integer> arr = Arrays.asList(2, 3, -1, 4, 5);
        System.out.println(maxSubarray(arr));
    }
    public static void main(String[] args) {
        new TheMaximumSubarray().run();
    }
}
