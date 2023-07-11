public class FibonacciRec {

    public int getFibRec(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        else {
            return getFibRec(n-1) + getFibRec(n-2);
        }
    }

    public void run() {
        int n = 4;
        System.out.println(getFibRec(n));
    }

    public static void main(String[] args) {
        new FibonacciRec().run();
    }
}