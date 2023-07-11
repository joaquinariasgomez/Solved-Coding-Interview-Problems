public class MinCostClimbingStairs {

    public int getMinCost(int[] arr) {
        int[] nCalls = {0};
        int sol = Math.min(getMinCostRec(arr, 0, nCalls), getMinCostRec(arr, 1, nCalls));
        System.out.println("Number of calls: "+nCalls[0]);
        return sol;
    }

    public int getMinCostRec(int[] arr, int step, int[] nCalls) {
        nCalls[0]++;
        if(step > arr.length-1) {
            return 0;
        }
        else {
            // We pay arr[step] and then jump one or two steps
            return Math.min(getMinCostRec(arr, step+1, nCalls)+arr[step], getMinCostRec(arr, step+2, nCalls)+arr[step]);
        }
    }

    public int getMinCostMemo(int[] arr) {
        int[] memo = new int[arr.length + 1];
        for(int i=0; i<memo.length; i++) {
            memo[i] = -1;
        }
        return Math.min(getMinCostRecMemo(arr, 0, memo), getMinCostRecMemo(arr, 1, memo));
    }

    public int getMinCostRecMemo(int[] arr, int step, int[] memo) {
        if(step > arr.length-1) {
            return 0;
        }
        else {
            if(memo[step] != -1) {
                return memo[step];
            }
            else {
                memo[step] = Math.min(getMinCostRecMemo(arr, step+1, memo)+arr[step], getMinCostRecMemo(arr, step+2, memo)+arr[step]);
                return memo[step];
            }
        }
    }

    public void run() {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(getMinCost(cost));
        System.out.println(getMinCostMemo(cost));
    }
    public static void main(String[] args) {
        new MinCostClimbingStairs().run();
    }
}