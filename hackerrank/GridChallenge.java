import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class GridChallenge {

    public String isOrderedColumns(List<String> grid) {
        List<String> sortedGrid = new ArrayList<String>();
        for(int i=0; i<grid.size(); i++) {
            char[] row = grid.get(i).toCharArray();
            Arrays.sort(row);
            sortedGrid.add(String.valueOf(row));
        }

        String condition = "YES";
        for(int i=0; i<sortedGrid.get(0).length(); i++) {
            for(int j=0; j<sortedGrid.size(); j++) {
                if(j>0 && sortedGrid.get(j).charAt(i) < sortedGrid.get(j-1).charAt(i)) {
                    condition = "NO";
                }
            }
        }
        return condition;
    }

    public void run() {
        List<String> grid = Arrays.asList("ebacd", "fghij", "olmkn", "trpqs", "xywuv");
        System.out.println(isOrderedColumns(grid));
    }
    public static void main(String[] args) {
        new GridChallenge().run();
    }
}
