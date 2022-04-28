import java.util.List;
import java.util.Arrays;

public class Ratios {
    public void getRatios(List<Integer> numbers) {
        int nPos = 0;
        int nNeg = 0;
        int nZero = 0;

        for(int element : numbers) {
            if(element > 0) nPos++;
            else {
                if(element < 0) nNeg++;
                else nZero++;
            }
        }

        System.out.println((float)nPos/numbers.size());
        System.out.println((float)nNeg/numbers.size());
        System.out.println((float)nZero/numbers.size());
    }

    public void run() {
        List<Integer> sample_numbers = Arrays.asList(1, 1, 0, -4, 3, -2);
        getRatios(sample_numbers);
    }
    public static void main(String[] args) {
        new Ratios().run();
    }
}
