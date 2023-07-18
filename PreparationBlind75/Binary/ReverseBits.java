public class ReverseBits {

    public int reverse(int n) {
        int sol = 0;
        for(int i=0; i<32; i++) {
            int rightMostBit = (n >> i) & 1;
            sol = sol | (rightMostBit << (31 - i));
        }
        return sol;
    }

    public void run() {
        int n = 00000000000000000000000000000100;
        System.out.println(reverse(n));
    }
    public static void main(String[] args) {
        new ReverseBits().run();
    }
}