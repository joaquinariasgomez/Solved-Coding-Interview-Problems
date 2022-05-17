import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PickingNumbers {
    public int longestSubArray(List<Integer> a) {
        if(a.size() == 0) return 0;
        int longest = 1;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e : a) {
            int currentCount = map.getOrDefault(e, 0);
            map.put(e, currentCount+1);
        }
        
        for(HashMap.Entry<Integer, Integer> entrySet : map.entrySet()) {
            int currentCount = entrySet.getValue();
            if(map.get(entrySet.getKey()+1) != null) {
                longest = Math.max(longest, currentCount+map.get(entrySet.getKey()+1));
            }
            else {
                longest = Math.max(longest, currentCount);
            }
        }
        
        return longest;
    }

    public void run() {
        List<Integer> list = Arrays.asList(4, 6, 5, 3, 3, 1);
        System.out.println(longestSubArray(list));
    }
    public static void main(String[] args) {
        new PickingNumbers().run();
    }
}
