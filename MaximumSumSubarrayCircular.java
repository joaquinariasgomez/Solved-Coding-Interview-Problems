public class MaximumSumSubarrayCircular {

    public int maxValue(int[] array) {
        int maxSum = array[0];
        int minSum = array[0];
        int currSum = array[0];
        int currMin = array[0];
        int totalSum = array[0];

        for (int i = 1; i < array.length; i++) {
            currSum = Math.max(currSum + array[i], array[i]);
            maxSum = Math.max(maxSum, currSum);

            currMin = Math.min(currMin + array[i], array[i]);
            minSum = Math.min(minSum, currMin);
            totalSum += array[i];
        }
        return totalSum == minSum ? maxSum : Math.max(maxSum, totalSum - minSum);
    }

    public void run() {
        int[] array = { -2, 2, 5, -11, 6 };
        System.out.println(maxValue(array));
    }

    public static void main(String[] args) {
        new MaximumSumSubarrayCircular().run();
    }
}
