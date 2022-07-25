public class CounterGame {

    public String powerOfTwo(long n) {
        //long nextPower = n & (~(n>>1));
        long a = n<<1;
        a = a>>1;
        System.out.println(a);
        //long nextPower = ~(n>>1) & n;
        //System.out.println(nextPower);
        return "";
    }

    public void run() {
        long n = 132;
        System.out.println(powerOfTwo(n));
    }
    public static void main(String[] args) {
        new CounterGame().run();
    }
}
