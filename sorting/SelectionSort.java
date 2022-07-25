public class SelectionSort {

    public int[] exch(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
        return nums;
    }

    public int[] selectionSort(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int min = i;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] < nums[min]) {
                    min = j;
                }
            }
            nums = exch(nums, min, i);
        }
        return nums;
    }

    public void run() {
        int[] nums = {5, 4, 3, 1, 2};
        int[] sorted = selectionSort(nums);
        for(int e : sorted) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new SelectionSort().run();
    }
}