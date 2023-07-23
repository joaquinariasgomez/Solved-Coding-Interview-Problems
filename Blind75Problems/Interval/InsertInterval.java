import java.util.*;

public class InsertInterval {

    public int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> sol = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0])
                sol.add(interval);
            else {
                // Check if newInterval is out
                if (newInterval[1] < interval[0]) {
                    sol.add(newInterval);
                    sol.add(interval);
                    newInterval = null;
                } else {
                    newInterval=new int[]{Math.min(newInterval[0],interval[0]),Math.max(newInterval[1],interval[1])};
                    // Dont add this, just yet
                }
            }
        }
        if(newInterval != null) sol.add(newInterval);
        return sol.toArray(new int[sol.size()][]);
    }

    public void run() {
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        int[][] newIntervals = insertInterval(intervals, newInterval);
        for(int[] myInterval : newIntervals) {
            System.out.print("["+myInterval[0]+", "+myInterval[1]+"], ");
        }
    }

    public static void main(String[] args) {
        new InsertInterval().run();
    }
}