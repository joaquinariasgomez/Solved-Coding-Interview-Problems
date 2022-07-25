public class LongestPalindromicSubstring {

    public String longestPalindrome(String word) {
        if(word==null || word.length() < 1) return "";

        int start = 0;
        int end = 0;

        for(int i=0; i<word.length(); i++) {
            int len1 = expandFromMiddle(word, i, i);
            int len2 = expandFromMiddle(word, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end-start) {
                start = i - ((len-1)/2);
                end = i + (len/2);
            }
        }

        return word.substring(start, end + 1);
    }

    public int expandFromMiddle(String word, int left, int right) {
        if(word==null || right < left) return 0;

        while(left>=0 && right<word.length() && word.charAt(left)==word.charAt(right)) {
            left--;
            right++;
        }
        return right-left+1;
    }

    public void run() {
        String word = "abcba";
        System.out.println(longestPalindrome(word));
    }
    public static void main(String[] args) {
        new LongestPalindromicSubstring().run();
    }
}
