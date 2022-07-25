import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BigSorting {
    
    class StringComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            if(s1.length() < s2.length()) {
                return -1;
            }
            if(s1.length() > s2.length()) {
                return 1;
            }
            return s1.compareTo(s2);    //Quizás puedo usar s1-s2
        }
    }

    public List<String> sortArray(List<String> array) {
        Collections.sort(array, new StringComparator());
        return array;
    }

    public void run() {
        List<String> array = Arrays.asList("31415926535897932384626433832795", "200", "150", "3");
        List<String> sorted = sortArray(array);
        for(String s : sorted) {
            System.out.print(s+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new BigSorting().run();
    }
}
