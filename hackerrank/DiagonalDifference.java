import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {
    public int diagonalDifference(List<List<Integer>> arr) {
        int primaryDiagSum = 0;
        int secondaryDiagSum = 0;
        
        for(int i=0; i<arr.size(); i++) {
            for(int j=0; j<arr.get(0).size(); j++) {
                if(i==j) {  //Main diagonal
                    primaryDiagSum += arr.get(i).get(j);
                }
                if(i+j == arr.size()-1) {      // Secondary diagonal
                    secondaryDiagSum += arr.get(i).get(j);
                }
            }
        }
        
        return Math.abs(primaryDiagSum - secondaryDiagSum);
    }

    public void run() {
        List<List<Integer>> matrix = Arrays.asList(Arrays.asList(1, 2, 3),
                                                   Arrays.asList(4, 5, 6),
                                                   Arrays.asList(9, 8, 9));
        System.out.println(diagonalDifference(matrix));
    }

    public static void main(String[] args) {
        new DiagonalDifference().run();
    }
}
