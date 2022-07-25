public class SumVsXOR {
    public long sumvsxor(long n) {
        int zeroCount = 0;
        while(n>0) {
            if(n%2==0) {
                zeroCount++;
            }
            n /= 2;
        }
        return 1l<<zeroCount;
    }

    public void run() {
        long n = 5;
        System.out.println(sumvsxor(n));
    }
    public static void main(String[] args) {
        new SumVsXOR().run();
    }
}
