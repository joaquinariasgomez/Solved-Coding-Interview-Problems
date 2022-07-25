import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class JesseAndCookies {

    public int nOperations(List<Integer> cookies, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for(int i=0; i<cookies.size(); i++) {
            minHeap.add(cookies.get(i));
        }

        int smallest;
        int secSmallest;
        int iterations = 0;

        while(minHeap.peek() < k && minHeap.size() > 1) {
            smallest = minHeap.poll();
            secSmallest = minHeap.poll();
            int newItem = smallest + 2 * secSmallest;
            minHeap.add(newItem);
            iterations++;
        }

        if(minHeap.peek() < k) iterations = -1;
        return iterations;
    }

    public void run() {
        List<Integer> cookies = Arrays.asList(2, 7, 3, 6, 4, 6);
        System.out.println(nOperations(cookies, 9));
    }
    public static void main(String[] args) {
        new JesseAndCookies().run();
    }
}