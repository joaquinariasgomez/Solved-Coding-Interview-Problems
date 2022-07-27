public class IterateInteger {

    public int calculateProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while(n > 9) {
            int rem = n%10;
            n = (int)Math.floor(n/10);
            product *= rem;
            sum += rem;
        }
        product *= n;
        sum += n;
        return product - sum;
    }

    public void run() {
        int n = 234;
        System.out.println(calculateProductAndSum(n));
    }

    public static void main(String[] args) {
        new IterateInteger().run();
    }
}