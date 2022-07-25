public class TwoSumInputArraySorted {
    public int[] twoSum(int[] numbers, int target) {
        int leftP = 0;
        int rightP = numbers.length - 1;
        int[] sol = new int[2];
        
        while(leftP < rightP) {
            int currSum = numbers[leftP] + numbers[rightP];
            if(currSum < target) {
                leftP++;
            }
            else {
                if(currSum > target) {
                    rightP--;
                }
                else {
                    sol[0] = leftP+1;
                    sol[1] = rightP+1;
                    return sol;
                }
            }
        }
        
        return sol;
    }
}