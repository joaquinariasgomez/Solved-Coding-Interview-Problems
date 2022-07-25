import java.util.List;
import java.util.Arrays;

public class FiveIntegersMinMax {
    public void miniMaxSum(List<Integer> arr) {
        long totalsum = 0;
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        
        for(int element : arr) {
            totalsum += element;
            if(element < minElement) minElement = element;
            if(element > maxElement) maxElement = element;
        }
        
        System.out.println((totalsum-(long)maxElement)+" "+(totalsum-(long)minElement));
    }

    public void run() {
        List<Integer> sample_numbers = Arrays.asList(1, 3, 5, 7, 9);
        miniMaxSum(sample_numbers);
    }
    public static void main(String[] args) {
        new FiveIntegersMinMax().run();
    }
}
