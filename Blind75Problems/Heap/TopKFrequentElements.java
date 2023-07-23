import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKfreq(int[] nums, int k) {
        int[] sol = new int[k];
        HashMap<Integer, Integer> freqs = new HashMap<Integer, Integer>();
        PriorityQueue<HashMap.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for(int n : nums) {
            freqs.put(n, freqs.getOrDefault(n, 0)+1);
        }
        for(HashMap.Entry<Integer, Integer> entrySet : freqs.entrySet()) {
            pq.add(entrySet);
        }
        for(int i=0; i<k; i++) {
            sol[i] = pq.poll().getKey();
        }

        return sol;
    }

    public void run() {
        int[] nums = {1,1,1,2,2,3};
        int k = 3;
        int[] res = topKfreq(nums, k);
        for(int i=0; i<res.length; i++) {
            System.out.print(res[i]+" ");
        } 
    }
    public static void main(String[] args) {
        new TopKFrequentElements().run();
    }
}