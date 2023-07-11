import java.util.List;
import java.util.ArrayList;

public class MinimalTree {

    public void insertMidElement(List<Integer> newNums, int[] input, int from, int to) {
        if(to < from) return;
        int midIndex = (from+to)/2;
        int midElement = input[midIndex];
        newNums.add(midElement);
        insertMidElement(newNums, input, midIndex+1, to);
        insertMidElement(newNums, input, from, midIndex-1);
    }

    public List<Integer> getOptimalOrder(int[] input) {
        List<Integer> newNums = new ArrayList<Integer>();
        insertMidElement(newNums, input, 0, input.length - 1);
        return newNums;
    }

    public void run() {
        int[] originalOrder = { 1, 4, 5, 7, 8, 13 };
        System.out.println(getOptimalOrder(originalOrder));
    }

    public static void main(String[] args) {
        new MinimalTree().run();
    }
}