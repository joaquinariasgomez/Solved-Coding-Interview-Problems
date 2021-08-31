import java.util.List;
import java.util.ArrayList;

public class BSTMinimumHeight {

    public void insertMidElement(List<Integer> newNums, int[] nums, int from, int to) {
        if(to < from) return;
        int midPointer = (from+to) / 2;
        int midElement = nums[midPointer];
        newNums.add(midElement);
        insertMidElement(newNums, nums, from, midPointer-1);
        insertMidElement(newNums, nums, midPointer+1, to);
    }

    public List<Integer> getCorrectOrder(int[] nums) {
        List<Integer> newNums = new ArrayList<Integer>();
        insertMidElement(newNums, nums, 0, nums.length-1);
        return newNums;
    }

    public void run() {
        int[] orderedNodes = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> correctOrder = getCorrectOrder(orderedNodes);
        for(int e : correctOrder) {
            System.out.print(e+" ");
        }
    }
    public static void main(String[] args) {
        new BSTMinimumHeight().run();
    }
}
