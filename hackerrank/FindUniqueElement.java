import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

public class FindUniqueElement {

    public int lonelyinteger(List<Integer> a) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int element : a) {
            if(set.contains(element)) {
                set.remove(element);
            }
            else {
                set.add(element);
            }
        }
        Integer[] remaining = set.toArray(new Integer[set.size()]);
        return remaining[0];
    }

    public void run() {
        List<Integer> test = Arrays.asList(1, 2, 3, 4, 3, 2, 1);
        System.out.println(lonelyinteger(test));
    }
    public static void main(String[] args) {
        new FindUniqueElement().run();
    }
}
