import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MigratoryBirds {

    public int minMostFrequent(List<Integer> arr) {
        PriorityQueue<HashMap.Entry<Integer, Integer>> maxHeap = new PriorityQueue<HashMap.Entry<Integer, Integer>>(
            (a,b) -> b.getValue()-a.getValue()
        );
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();    // Index, Frequency
        for(int e : arr) {
            map.put(e, map.getOrDefault(e, 0)+1);
        }
        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        HashMap.Entry<Integer, Integer> entry = maxHeap.poll();
        int minMostFreq = entry.getKey();
        int minMostFreqValue = entry.getValue();
        while(!maxHeap.isEmpty()) {
            entry = maxHeap.poll();
            if(entry.getValue() == minMostFreqValue && entry.getKey() < minMostFreq) {
                minMostFreq = entry.getKey();
            }
        }
        return minMostFreq;
    }

    public void run() {
        List<Integer> birds = Arrays.asList(1, 1, 2, 2, 3);
        System.out.println(minMostFrequent(birds));
    }
    public static void main(String[] args) {
        new MigratoryBirds().run();
    }
}
