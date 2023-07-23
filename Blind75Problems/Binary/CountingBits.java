public class CountingBits {

    public int[] solSlow(int n) {   // O(n * log n)
        int[] sol = new int[n+1];

        for(int i=0; i<=n; i++) {
            // Count ones of i
            int a = i;
            while(a > 0) {
                if((a & 1) == 1) sol[i]++;
                a = a >> 1;
            }
        }
        return sol;
    }

    public int[] solDp(int n) { // O(n)
        int[] sol = new int[n+1];
        sol[0] = 0;

        int offset = 1;     // Highest power of two
        for(int i=1; i<=n; i++) {
            if(offset*2 == i) offset = i;
            sol[i] = 1 + sol[i-offset];
        }
        return sol;
    }

    public void run() {
        int n = 7;
        int[] sol = solDp(n);
        for(int a : sol) {
            System.out.print(a+", ");
        }
    }
    public static void main(String[] args) {
        new CountingBits().run();
    }
}