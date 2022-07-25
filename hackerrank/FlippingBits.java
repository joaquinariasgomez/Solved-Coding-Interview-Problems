public class FlippingBits {
    public long flip(long n) {
        long mask=(1l<<32)-1;
        return (~n)&mask;
    }

    public void run() {
        long n=9;
        System.out.println(flip(n));
    }
    public static void main(String[] args) {
        new FlippingBits().run();
    }
}
