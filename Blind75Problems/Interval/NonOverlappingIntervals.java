import java.util.*;

public class NonOverlappingIntervals {

    public int overlappingInterval(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int nOverlaps = 0;
        int[] prevInterval = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            if(prevInterval[1] > intervals[i][0]) { // There is an overlap
                nOverlaps++;
                // Now, "remove" last ending interval
                if(prevInterval[1] > intervals[i][1]) {
                    prevInterval = intervals[i];
                }
            }
            else {
                prevInterval = intervals[i];
            }
        }
        return nOverlaps;
    }

    /*
     *  .-----. .-----. .-----.
     *     .---------------. 
     * 
     */

    public void run() {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        int n = overlappingInterval(intervals);
        System.out.println(n);
        // for (int[] myInterval : newIntervals) {
        // System.out.print("[" + myInterval[0] + ", " + myInterval[1] + "], ");
        // }
    }

    public static void main(String[] args) {
        new NonOverlappingIntervals().run();
    }
}