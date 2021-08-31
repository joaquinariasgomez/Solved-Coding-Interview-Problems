import java.util.HashMap;

public class FrogRiverOne {

    private int earliestTime(int x, int[] array) {
        int steps = x;
        boolean[] seen = new boolean[x + 1];

        for(int i=0; i<array.length; ++i) {
            if(!seen[array[i]]) {
                seen[array[i]] = true;
                steps--;
                if(steps == 0) return i;
            }
        }

        return -1;
    }

    private void run() {
        int x = 4;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(this.earliestTime(x, A));
    }

    public static void main(String[] args) {
        new FrogRiverOne().run();
    }
}
