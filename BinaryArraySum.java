public class BinaryArraySum {

    public String sum(String b1, String b2) {
        char[] array1 = b1.toCharArray();
        char[] array2 = b2.toCharArray();
        char[] result = new char[Math.max(array1.length, array2.length)];
        int carry = 0;
        int it1 = array1.length-1;
        int it2 = array2.length-1;
        for(int i=result.length-1; i>=0; i--) {
            int actualSum = carry;
            if(it1 >= 0) actualSum += Character.getNumericValue(array1[it1--]);
            if(it2 >= 0) actualSum += Character.getNumericValue(array2[it2--]);
            if(actualSum > 1) {
                carry = 1;
                result[i] = '0';
            }
            else {
                carry = 0;
                result[i] = (char)(actualSum+'0');
            }
        }
        if(carry == 1) {
            result = new char[result.length+1];
            result[0] = '1';
            for(int i=1; i<result.length; i++) {
                result[i] = '0';
            }
        }
        return String.valueOf(result);
    }

    public void run() {
        String b1 = "11010";
        String b2 = "111";
        System.out.println(sum(b1, b2));
    }
    public static void main(String[] args) {
        new BinaryArraySum().run();
    }
}
