public class MaximumSumSubarray {

    public int maxValue(int[] array) {
        int max_sum = array[0];
        int current_sum = array[0];
        for(int i=1; i<array.length; i++) {
            current_sum = Math.max(current_sum + array[i], array[i]);
            System.out.println("Current sum: "+current_sum+ " i: "+i);
            max_sum = Math.max(max_sum, current_sum);
        }
        return max_sum;
    }

    public void run() {
        // int[] array = {-2,2,5,-11,6};
        int[] array = {-2, -1, 2, -3};
        System.out.println(maxValue(array));
    }
    public static void main(String[] args) {
        new MaximumSumSubarray().run();
    }
}
