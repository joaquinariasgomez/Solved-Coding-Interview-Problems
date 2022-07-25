public class InsertionSort {

    public int[] exch(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
        return nums;
    }

    public int[] insertionSort(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int j=i;
            while(j>0 && nums[j] < nums[j-1]) {
                nums = exch(nums, j, j-1);
                j--;
            }
        }
        return nums;
    }

    public void run() {
        int[] nums = {5, 4, 3, 1, 2};
        int[] sorted = insertionSort(nums);
        for(int e : sorted) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new InsertionSort().run();
    }
}
