public class PalindromeIndex {
    public int getIndex(String s) {
        int begin = 0;
        int end = s.length()-1;
        while(begin<end) {
            if(s.charAt(begin)!=s.charAt(end)) {
                if(isPalindrome(s, begin, end-1)) {
                    return end;
                }
                else {
                    return begin;
                }
            }
            begin++;
            end--;
        }
        return -1;
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while(begin<end) {
            if(s.charAt(begin)!=s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public void run() {
        String s = "abcctba";
        System.out.println(getIndex(s));
    }
    public static void main(String[] args) {
        new PalindromeIndex().run();
    }
}
