import java.util.Arrays;
import java.util.List;

public class FindTheMedian {

    public int median(List<Integer> arr) {
        Integer[] arrPrim = new Integer[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            arrPrim[i] = arr.get(i);
        }
        
        Arrays.sort(arrPrim);
        return arrPrim[arrPrim.length/2];
    }

    public void run() {
        List<Integer> array = Arrays.asList(5, 3, 1, 2, 4);
        System.out.println(median(array));
    }
    public static void main(String[] args) {
        new FindTheMedian().run();
    }
}
