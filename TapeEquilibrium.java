import java.lang.Math;

public class TapeEquilibrium {

    private int minDifference(int[] array) {
        double sumLeft = array[0];
        double sumRight = 0;

        for(int i=1; i<array.length; ++i) {
            sumRight += array[i];
        }
        double bestDiff = Math.abs(sumLeft - sumRight);

        for(int p=1; p<array.length; ++p) {
            sumLeft += array[p];
            sumRight -= array[p];
            double newDiff = Math.abs(sumLeft - sumRight);
            if(newDiff < bestDiff) bestDiff = newDiff;
        }

        return (int)bestDiff;
    }

    private void run() {
        int[] array = {3, 1};
        System.out.println(minDifference(array));
    }

    public static void main(String[] args) {
        new TapeEquilibrium().run();
    }
}
