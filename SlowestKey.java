import java.util.HashMap;
import java.util.PriorityQueue;

public class SlowestKey {

    public char getSlowest(int[] releaseTimes, String keysPressed) {
        HashMap<Integer, Character> map = new HashMap<Integer, Character>();
        PriorityQueue<HashMap.Entry<Integer, Character>> maxHeap = new PriorityQueue<HashMap.Entry<Integer, Character>>(
            (a,b) -> b.getKey()-a.getKey()
        );

        int prev = 0;
        for(int i=0; i<releaseTimes.length; i++) {
            if (map.containsKey(releaseTimes[i]-prev)) {
                char currentValue = map.get(releaseTimes[i]-prev);
                if(keysPressed.charAt(i) > currentValue) {
                    map.put(releaseTimes[i]-prev, keysPressed.charAt(i));
                }
            }
            else {
                map.put(releaseTimes[i]-prev, keysPressed.charAt(i));
            }
            prev = releaseTimes[i];
        }

        for(HashMap.Entry<Integer, Character> it : map.entrySet()) {
            maxHeap.add(it);
        }

        return maxHeap.peek().getValue();
    }

    public void run() {
        int[] releaseTimes = {9, 29, 49, 50};
        String keysPressed = "cbcd";
        char slowest = getSlowest(releaseTimes, keysPressed);
        System.out.println(slowest);
    }
    public static void main(String[] args) {
        new SlowestKey().run();
    }
}
