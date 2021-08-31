public class Mergesort {

    public void sort(int[] nums, int[] aux, int lo, int hi) {
        if(hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        sort(nums, aux, lo, mid);
        sort(nums, aux, mid+1, hi);
        merge(nums, aux, lo, mid, hi);
    }

    public void merge(int[] nums, int[] aux, int lo, int mid, int hi) {    // Precondition: sub arrays are sorted
        for(int k=lo; k<=hi; k++) {
            aux[k] = nums[k];
        }
        int i = lo, j = mid+1;
        for(int k=lo; k<=hi; k++) {
            if(i>mid)
                nums[k] = aux[j++];
            else if(j>hi)
                nums[k] = aux[i++];
            else if(aux[i]<aux[j])
                nums[k] = aux[i++];
            else
                nums[k] = aux[j++];
        }
    }

    public void run() {
        int[] nums = {4,3,2,1,1,2,4,4};
        int[] aux = new int[nums.length];
        sort(nums, aux, 0, nums.length-1);
        for(int e: nums) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new Mergesort().run();
    }
}
