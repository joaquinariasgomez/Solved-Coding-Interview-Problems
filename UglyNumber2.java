import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class UglyNumber2 {

    public void fillSet(int n, int current, HashSet<Integer> set) {
        if(set.size() == n) {
            return;
        }
        else {
            set.add(current);
            fillSet(n, current*2, set);
            fillSet(n, current*3, set);
            fillSet(n, current*5, set);
        }
    }

    public void fillSet(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        while(!queue.isEmpty() && set.size() < n) {
            int element = queue.poll();
            set.add(element);
            // Generate childs of element: element * 2, element * 3, element * 5
            queue.add(element*2);
            queue.add(element*3);
            queue.add(element*5);
        }
        int[] sortedElements = new int[n];
        int i=0;
        for(int element:set) {
            sortedElements[i++] = element;
        }
        Arrays.sort(sortedElements);
        System.out.println(sortedElements[n-1]);
    }

    public void run() {
        int n = 10;
        fillSet(n);
    }
    public static void main(String[] args) {
        new UglyNumber2().run();
    }
}
