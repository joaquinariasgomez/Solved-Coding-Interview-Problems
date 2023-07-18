public class NumberOf1Bits {

    public int getNOnes(int n) {
        int counter = 0;

        for(int i=0; i<32; i++) {
            if((1 & n) == 1) counter++;
            n = n >> 1;
        }

        return counter;
    }

    public void run() {
        int n = 00000000000000000000000000001011;
        System.out.println(getNOnes(n));
    }
    public static void main(String[] args) {
        new NumberOf1Bits().run();
    }
}