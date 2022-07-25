public class MaximizingXOR {

    public int maximizing(int l, int r) {
        int max = 0;
        for(int i=l; i<r; i++) {
            for(int j=i+1; j<=r; j++) {
                max = Math.max(max, (i^j));
            }
        }
        return max;
    }

    public void run() {
        int l = 10;
        int r = 15;
        System.out.println(maximizing(l, r));
    }
    public static void main(String[] args) {
        new MaximizingXOR().run();
    }
}
