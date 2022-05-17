import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MagicSquare {

    public int getCostDifference(List<List<Integer>> m1, int[][] m2) {
        int currentCost = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                currentCost += Math.abs(m1.get(i).get(j)-m2[i][j]);
            }
        }
        return currentCost;
    }

    public int minChangesCost(List<List<Integer>> inputMatrix) {
        int a[][]={{2,7,6},{9,5,1},{4,3,8}};
        int b[][]={{2,9,4},{7,5,3},{6,1,8}};
        int c[][]={{4,3,8},{9,5,1},{2,7,6}};
        int d[][]={{4,9,2},{3,5,7},{8,1,6}};
        int e[][]={{6,1,8},{7,5,3},{2,9,4}};
        int f[][]={{6,7,2},{1,5,9},{8,3,4}};
        int g[][]={{8,1,6},{3,5,7},{4,9,2}};
        int h[][]={{8,3,4},{1,5,9},{6,7,2}};
        List<int[][]> solutions = new ArrayList<>();
        solutions.add(a); solutions.add(b); solutions.add(c); solutions.add(d); solutions.add(e); solutions.add(f); solutions.add(g); solutions.add(h);

        int minCost = Integer.MAX_VALUE;
        for(int[][] possibleSol : solutions) {
            minCost = Math.min(minCost, getCostDifference(inputMatrix, possibleSol));
        }
        return minCost;
    }

    public void run() {
        List<List<Integer>> inputMatrix = Arrays.asList(Arrays.asList(5, 3, 4),
                                                        Arrays.asList(1, 5, 8),
                                                        Arrays.asList(6, 4, 2));
        System.out.println(minChangesCost(inputMatrix));
    }
    public static void main(String[] args) {
        new MagicSquare().run();
    }
}
