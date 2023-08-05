import java.util.HashMap;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String s) {
        PriorityQueue<HashMap.Entry<Character, Integer>> maxHeap = new PriorityQueue<HashMap.Entry<Character, Integer>>((a, b) -> (b.getValue() - a.getValue()));
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {                                 // O(n)
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(HashMap.Entry<Character, Integer> entry : map.entrySet()) { // O(n)
            maxHeap.add(entry);
        }
        StringBuilder sol = new StringBuilder();

        char prev = ' ';
        while(!maxHeap.isEmpty()) {
            if(maxHeap.peek().getKey() != prev) {
                // Use that char to sol
                HashMap.Entry<Character, Integer> maxEntry = maxHeap.poll();
                sol.append(maxEntry.getKey());
                prev = maxEntry.getKey();
                maxEntry.setValue(maxEntry.getValue()-1);
                if(maxEntry.getValue() != 0)
                    maxHeap.add(maxEntry);
            }
            else {
                if(maxHeap.size() == 1) {
                    return "";
                }
                else {
                    HashMap.Entry<Character, Integer> maxEntry = maxHeap.poll();
                    HashMap.Entry<Character, Integer> secMaxEntry = maxHeap.poll();
                    sol.append(secMaxEntry.getKey());
                    prev = secMaxEntry.getKey();
                    secMaxEntry.setValue(secMaxEntry.getValue()-1);
                    if(secMaxEntry.getValue() != 0) {
                        maxHeap.add(secMaxEntry);
                    }
                    maxHeap.add(maxEntry);
                }
            }
        }
        return sol.toString();
    }

    public void run() {
        String s = "aaabc";
        System.out.println(reorganizeString(s));
    }
    public static void main(String[] args) {
        new ReorganizeString().run();
    }
}