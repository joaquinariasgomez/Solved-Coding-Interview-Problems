import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargestElements {
    public int[] klargest(int[] array, int k) {
        int[] solution = new int[k];
        //PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b-a);

        for(int e: array) {
            heap.add(e);
        }
        for(int i = 0; i< k; i++) {
            solution[i] = heap.remove();
        }

        return solution;
    }

    public void run() { //Complexity O(n + k*log(n))
                        // N Additions: O(n)
                        // K Extractions: O(k*log(n))
        int[] array = {4, 1, 3, 12, 7, 14};
        int k = 3;
        int[] solution = klargest(array, k);
        for(int e: solution) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new KLargestElements().run();
    }
}
