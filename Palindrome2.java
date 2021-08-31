public class Palindrome2 {

    public boolean isPalindrome(String array) {
        int start = 0;
        int end = array.length() - 1;

        while(start < end) {
            if(array.charAt(start) != array.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public void run() {
        String array="bab";
        System.out.println(isPalindrome(array));
    }

    public static void main(String[] args) {
        new Palindrome2().run();
    }
}