public class Fibonacci {

    public int fibonacci(int n) {
        int[] memo = new int[n+1];
        if(n>=0) memo[0] = 0;
        if(n>=1) memo[1] = 1;
        for(int i=2; i<=n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }

    public void run() {
        int n = 4;
        System.out.println(fibonacci(n));
    }
    public static void main(String[] args) {
        new Fibonacci().run();
    }
}