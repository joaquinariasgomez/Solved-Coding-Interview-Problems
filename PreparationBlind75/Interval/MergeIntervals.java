import java.util.*;

public class MergeIntervals {

    public int[][] mergeIntervals(int[][] intervals) {
        List<int[]> sol = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        sol.add(intervals[0]);

        for(int i=1; i<intervals.length; i++) {
            int prevEnd = sol.get(sol.size()-1)[1];
            if(prevEnd >= intervals[i][0]) {    // Merge prev and curr interval
                sol.get(sol.size()-1)[1] = Math.max(prevEnd, intervals[i][1]);
            }
            else {
                sol.add(intervals[i]);
            }
        }

        return sol.toArray(new int[sol.size()][]);
    }

    public void run() {
        int[][] intervals = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
        int[][] newIntervals = mergeIntervals(intervals);
        for (int[] myInterval : newIntervals) {
        System.out.print("[" + myInterval[0] + ", " + myInterval[1] + "], ");
        }
    }

    public static void main(String[] args) {
        new MergeIntervals().run();
    }
}