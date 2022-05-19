import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutingTwoArrays {

    public String twoArrays(int k, List<Integer> A, List<Integer> B) {
        Integer[] a = new Integer[A.size()];
        Integer[] b = new Integer[B.size()];
        
        for(int i=0; i<a.length; i++) {
            a[i] = A.get(i);
            b[i] = B.get(i);
        }
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        for(int i=0; i<a.length; i++) {
            if(a[i]+b[i]<k)
                return "NO";
        }
        return "YES";
    }

    public void run() {
        List<Integer> A = Arrays.asList(0, 1);
        List<Integer> B = Arrays.asList(0, 2);
        System.out.println(twoArrays(1, A, B));
    }
    public static void main(String[] args) {
        new PermutingTwoArrays().run();
    }
}
