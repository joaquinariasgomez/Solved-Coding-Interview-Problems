public class Multiply {

    public int multiply(int n, int t) {
        if(t<0) {
            t=-t;
            n=-n;
        }
        if(t==0) {
            return 0;
        }
        else {
            return n + multiply(n, t-1);
        }
    }

    public int iterativeMultiply(int n, int t) {    // Dynamic programming approach
        if(t<0) {
            t=-t;
            n=-n;
        }
        int[] memo = new int[t+1];
        memo[0] = 0;

        for(int i=1; i<=t; i++) {
            memo[i] = n + memo[i-1];
        }
        return memo[t];
    }

    public void run() {
        int n = 0;
        int t = 30;
        System.out.println(multiply(n,t));
        System.out.println(iterativeMultiply(n,t));
    }
    public static void main(String[] args) {
        new Multiply().run();
    }
}
