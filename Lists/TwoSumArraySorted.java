class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int begin = 0;
        int end = numbers.length -1;
        int[] sol = new int[2];
        
        while(begin < end) {
            int currentSum = numbers[begin] + numbers[end];
            if(currentSum > target) {
                end--;
            }
            else {
                if(currentSum < target) {
                    begin++;        
                }
                else {
                    sol[0] = begin+1;
                    sol[1] = end+1;
                    break;
                }
            }
        }
        
        return sol;
    }
}
