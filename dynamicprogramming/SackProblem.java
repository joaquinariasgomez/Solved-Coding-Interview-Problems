public class SackProblem {

    public int maxValue(int[] v, int[] p, int c) {
        int n = v.length;
        int[][] f = new int[n+1][c+1];

        for(int i=0; i<=c; i++) {
            if(i<p[0]) {
                f[0][i] = 0;
            }
            else {
                f[0][i] = v[0];
            }
        }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=c; j++) {
                if(j < p[i-1]) {
                    f[i][j] = f[i-1][j];
                }
                else {
                    f[i][j] = Math.max(
                        f[i-1][j],
                        v[i-1] + f[i-1][j-p[i-1]]
                    );
                }
            }
        }

        return f[n][c];
    }

    public void run() {
        int[] v = {1,4,2,3,3};
        int[] p = {8,3,3,1,2};
        int c = 8;
        System.out.println(maxValue(v,p,c));
    }
    public static void main(String[] args) {
        new SackProblem().run();
    }
}
