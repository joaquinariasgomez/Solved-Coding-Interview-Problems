import java.util.Arrays;
import java.util.List;

public class ArraysDS {
    public List<Integer> reverse(List<Integer> a) {
        int begin=0;
        int end=a.size()-1;
        while(begin<end) {
            int aux = a.get(end);
            a.set(end, a.get(begin));
            a.set(begin, aux);
            begin++;
            end--;
        }
        return a;
    }

    public void run() {
        List<Integer> array = Arrays.asList(1, 2, 3);
        List<Integer> sol = reverse(array);
    }
    public static void main(String[] args) {
        new ArraysDS().run();
    }
}
