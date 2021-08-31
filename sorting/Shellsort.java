public class Shellsort {
    public int[] exch(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
        return nums;
    }

    public int[] shellsort(int[] nums) {
        int n = nums.length;
        int h = 1;
        while(h < n/3) h = 3*h + 1; // 3*x + 1 increment sequence

        do { // h-sort the array using insertion sort
            for(int i=h; i<n; i++) {
                int j=i;
                while(j>=h && nums[j] < nums[j-h]) {
                    exch(nums, j, j-h);
                    j-=h;
                }
            }
            h = h/3;    // Move to next increment
        } while(h >= 1);
        return nums;
    }

    public void run() {
        int[] nums = {5, 4, 3, 1, 2, 5, 4, 3, 1, 2};
        int[] sorted = shellsort(nums);
        for(int e : sorted) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new Shellsort().run();
    }
}
