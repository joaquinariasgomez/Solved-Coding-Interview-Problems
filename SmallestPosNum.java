import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SmallestPosNum {

    private int minNumber(int[] array) {
        int minNumber = 1;
        if(array.length == 0) return minNumber;
        List<Integer> sortedList = new ArrayList<Integer>();
        for(Integer a : array) {
            if(a > 0) sortedList.add(a);
        }
        //Sort list
        Collections.sort(sortedList);
        for(Integer a : sortedList) {
            if(a != minNumber) {
                return minNumber;
            }
            else {
                ++minNumber;
            }
        }
        return minNumber;
    }

    private void run() {
        int[] array = {1, 1, 0, -1, -2};
        System.out.println(minNumber(array));
    }

    public static void main(String[] args){
        new SmallestPosNum().run();
    }
}
