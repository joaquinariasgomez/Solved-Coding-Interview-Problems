import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumChars {

    private int minDeletions(char[] s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        for(int c = 0; c < s.length; ++c) {
            if(mp.containsKey(s[c])) {
                mp.put(s[c], mp.get(s[c]) + 1);
            }
            else {
                mp.put(s[c], 1);
            }
        }

        for(Map.Entry<Character, Integer> it : mp.entrySet()) {
            pq.add(it.getValue());
        }

        int cntChar = 0;
        while(!pq.isEmpty()) {
            int frequent = pq.poll();

            if(pq.isEmpty()) {
                return cntChar;
            }

            if(frequent == pq.peek()) {
                if(frequent > 1) {
                    pq.add(frequent - 1);
                }

                cntChar++;
            }

        }

        return cntChar;
    }

    private void run() {
        String s = "abbbcccd";
        char[] array = s.toCharArray();
        System.out.println(minDeletions(array));
    }

    public static void main(String[] args) {
        new MinimumChars().run();
    }
}
