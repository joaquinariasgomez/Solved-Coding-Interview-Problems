public class ReverseInteger {
    public int reverse(int integer) {
        int solution = 0;

        boolean negative = false;
        if(integer<0) {
            integer = -integer;
            negative = true;
        }

        while(integer > 0) {
            int mod = integer % 10;
            integer = (int)Math.floor(integer/10);
            solution = solution * 10 + mod;
        }
        return negative ? -solution : solution;
    }

    public void run() {
        int integer = 123;
        System.out.println(reverse(integer));
    }
    public static void main(String[] args) {
        new ReverseInteger().run();
    }
}
