public class PalindromeBasic {
    public boolean isPalindrome(String str) {
        int begin = 0;
        int end = str.length()-1;
        while(begin < end) {
            if(str.charAt(begin) != str.charAt(end)) {
                return false;
            }
            else {
                begin++;
                end--;
            }
        }
        return true;
    }

    public void run() {
        String str = "racecars";
        System.out.println(isPalindrome(str));
    }
    public static void main(String[] args) {
        new PalindromeBasic().run();
    }
}