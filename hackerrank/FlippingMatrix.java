import java.util.List;
import java.util.Arrays;

public class FlippingMatrix {
    public int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int max = 0;
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                max = Integer.MIN_VALUE;
                max = Math.max(max, matrix.get(i).get(j));
                max = Math.max(max, matrix.get(i).get(2*n-j-1));
                max = Math.max(max, matrix.get(2*n-i-1).get(j));
                max = Math.max(max, matrix.get(2*n-i-1).get(2*n-j-1));
                sum += max;
            }
        }
        return sum;
    }
    
    public void run() {
        List<List<Integer>> matrix = Arrays.asList(Arrays.asList(1, 2, 3, 4),
                                                    Arrays.asList(5, 6, 7, 8),
                                                    Arrays.asList(9, 10, 11, 12),
                                                    Arrays.asList(13, 14, 15, 16));
        System.out.println(flippingMatrix(matrix));
    }
    public static void main(String[] args) {
        new FlippingMatrix().run();
    }
}
