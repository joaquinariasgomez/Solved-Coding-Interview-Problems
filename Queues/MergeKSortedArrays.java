import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public int[] mergeKSortedArray(int[][] arrays) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(); // minHeap
        int arraysSize = 0;
        for(int i=0; i<arrays.length; i++) {
            for(int j=0; j<arrays[0].length; j++) {
                heap.add(arrays[i][j]);
                arraysSize++;
            }
        }
        int[] sorted = new int[arraysSize];
        int counter=0;

        while(!heap.isEmpty()) {
            int smallest = heap.poll();
            sorted[counter++] = smallest;
        }

        return sorted;
    }

    public void run() {
        int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
 
		int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
		for(int e:result) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new MergeKSortedArrays().run();
    }
}