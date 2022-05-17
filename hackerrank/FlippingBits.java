public class FlippingBits {

    public void flip(int number) {
        long max = Integer.MAX_VALUE * 2 + 1;
        long opposite = ~(long)number & max;
        System.out.println(opposite);
    }

    public void run() {
        int n=5;
        flip(n);
    }
    public static void main(String[] args) {
        new FlippingBits().run();
    }
}
