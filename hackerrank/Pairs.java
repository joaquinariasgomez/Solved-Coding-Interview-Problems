import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

public class Pairs {
    public int pairs(int k, List<Integer> arr) {
        int sol = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<arr.size(); i++) {
            set.add(arr.get(i));
        }
        
        for(int i=0; i<arr.size(); i++) {
            int remaining = arr.get(i) + k;
            if(set.contains(remaining)) {
                sol++;
            }
        }
        
        return sol;
    }

    public void run() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        System.out.println(pairs(1, list));
    }

    public static void main(String[] args) {
        new Pairs().run();
    }
}
