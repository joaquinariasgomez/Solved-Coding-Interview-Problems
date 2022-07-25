public class NWays {

    public int nways(int n) {   // DYNAMIC PROGRAMMING
        int[] memo = new int[n+1];
        if(n>=0) memo[0] = 1;
        if(n>=1) memo[1] = 1;
        if(n>=2) memo[2] = 2;
        for(int i=3; i<=n; i++) {
            memo[i] = memo[i-1]+memo[i-2]+memo[i-3];
        }
        return memo[n];
    }

    public int recursive(int n) {   // NOT DYNAMIC PROGRAMMING
        if(n<0) {
            return 0;
        }
        else if(n==0) {
            return 1;
        }
        else {
            return recursive(n-1)+recursive(n-2)+recursive(n-3);
        }
    }

    public void run() {
        int n =20;
        System.out.println(nways(n));
        System.out.println(recursive(n));
    }
    public static void main(String[] args) {
        new NWays().run();
    }
}
