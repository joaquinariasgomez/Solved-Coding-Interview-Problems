import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SparseArrays {

    public List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();  //Value of key: number of times that it appears in strings array
        List<Integer> sol = new ArrayList<Integer>();
        
        for(String string : strings) {
            int value = map.getOrDefault(string, 0);
            map.put(string, value+1);
        }
        
        for(String query : queries) {
            if(map.containsKey(query)) {
                sol.add(map.get(query));
            }
            else {
                sol.add(0);
            }
        }
        return sol;
    }


    public void run() {
        List<String> strings = Arrays.asList("ab", "ab", "abc");
        List<String> queries = Arrays.asList("ab", "abc", "bc");

        List<Integer> sol = matchingStrings(strings, queries);
        for(int e:sol) System.out.print(e+" ");
    }
    public static void main(String[] args) {
        new SparseArrays().run();
    }
}
