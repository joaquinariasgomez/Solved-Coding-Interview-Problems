public class TwoSumArraySorted {
    int left = 0;
        int right = numbers.length-1;
        int[] solution = new int[2];
        while(left<right) {
            if(numbers[left]+numbers[right] > target) {
                right--;
            }
            else {
                if(numbers[left]+numbers[right] < target) {
                    left++;
                }
                else {
                    solution[0] = left+1;
                    solution[1] = right+1;
                    return solution;
                }
            }
        }
        return solution;
}
