public class AddTwoNumbers {

    public int getSum(int n1, int n2) {
        int res = 0;
        int carry = 0;
        for(int i=0; i<32; i++) {
            int currSum = (n1 & 1) + (n2 & 1) + carry;  // 0, 1 or 2
            if(currSum > 1) {
                carry = 1;
                currSum = 0;
            }
            else {
                carry = 0;
                if(currSum == 0) return res;
            }
            n1 >>= 1;
            n2 >>= 1;
            res |= currSum;
            System.out.print(res);
            res <<= 1;
            System.out.println(" "+res);
        }
        return res;
    }

    public void run() {
        int n1 = 4;      // 000000100
        int n2 = 5;      // 000000101
                        //  000000001

        System.out.println(getSum(n1, n2));
    }
    public static void main(String[] args) {
        new AddTwoNumbers().run();
    }
}