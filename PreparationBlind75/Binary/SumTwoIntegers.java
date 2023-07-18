public class SumTwoIntegers {

    public int DoSum(int a, int b) {
        //System.out.println("XOR: "+(a^b));              //01 ^ 10 = 11 -> 3
        //System.out.println("we have carry: "+((a&b)<<1));    //11 & 01 = 01 -> 1
                                                             // 01 << 1 = 10 -> 2
        while(b!=0) {
            int prevA = a;
            a = a^b;
            b = (prevA&b)<<1;
        }
        return a;
    }

    public void run() {
        int a = 22;
        int b = 30;
        System.out.println(DoSum(a, b));
    }
    public static void main(String[] args) {
        new SumTwoIntegers().run();
    }
}