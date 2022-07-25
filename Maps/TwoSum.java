import java.util.HashSet;

public class TwoSum {

    public boolean twoSum(int[] array, int sum) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i=0; i<array.length; i++) {
            int compliment = sum - array[i];
            if(hashSet.contains(compliment)) {
                return true;
            }
            hashSet.add(array[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] array = {2, 3, 11, 7};
        int sum = 9;
        boolean result = new TwoSum().twoSum(array, sum);
        System.out.println(result);
    }
}
