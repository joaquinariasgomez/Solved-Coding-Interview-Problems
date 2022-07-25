import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ComparisonSorting {
    public List<Integer> countingSort(List<Integer> arr) {
        List<Integer> freqArray = new ArrayList<Integer>(100);
        for(int i=0; i<100; i++) {
            freqArray.add(0);
        }
        
        for(int element : arr) {
            freqArray.set(element, freqArray.get(element)+1);
        }
        return freqArray;
    }

    public void run() {
        List<Integer> array = Arrays.asList(1, 1, 3, 2 , 1);
        List<Integer> result = countingSort(array);
        for(int e : result) {
            System.out.print(e + " ");
        }
    }
    public static void main(String[] args) {
        new ComparisonSorting().run();
    }   
}
