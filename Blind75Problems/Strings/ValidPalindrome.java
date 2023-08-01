public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length()-1;

        while(begin < end) {
            if(!Character.isLetterOrDigit(s.charAt(begin))) {
                begin++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(begin)) == Character.toLowerCase(s.charAt(end))) {
                begin++;
                end--;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public void run() {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
    public static void main(String[] args) {
        new ValidPalindrome().run();
    }
}