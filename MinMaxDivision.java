import java.lang.Math;

public class MinMaxDivision {

    private boolean IsDivisable(int[] A, int targetSum, int K) {
        int currentSum = 0;
        int maxKAllowed = K;

        for(int i=0; i<A.length; ++i) {
            currentSum += A[i];

            if(currentSum > targetSum) {
                maxKAllowed--;
                currentSum = A[i];
            }

            if(maxKAllowed == 0) {
                return false;
            }
        }
        return true;
    }

    private int minmaxdiv(int[] A, int K, int M) {
        int result = 0;
        int minSum = 0;
        int maxSum = 0;
        for(int i=0; i<A.length; ++i) {
            maxSum += A[i];
            minSum = Math.max(minSum, A[i]);
        }
        
        while(minSum <= maxSum) {
            int midSum = (minSum + maxSum) / 2;
            boolean isDivisable = this.IsDivisable(A, midSum, K);
            if(!isDivisable) {
                // not ok, lets try bigger
                minSum = midSum + 1;
            }
            else {
                // we can try smaller
                maxSum = midSum - 1;
                result = midSum;
            }
        }
        return result;
    }

    private void run() {
        int[] A = {2, 1, 5, 1, 2, 2, 2};
        int K = 3;
        int M = 5;
        System.out.println(this.minmaxdiv(A, K, M));
    }

    public static void main(String[] args) {
        new MinMaxDivision().run();
    }
}
