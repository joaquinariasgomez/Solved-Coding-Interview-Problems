public class LongestPalindromicSubstring {

    public String getLongestPalindrome(String s) {
        String longest = "";
        int[][] memo = new int[s.length()][s.length()];
        for(int i=0; i<memo.length; i++)
            for(int j=0; j<memo[0].length; j++)
                memo[i][j] = -1;
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {   // Get every substring combination
                if(isPalindrome(s, i, j, memo) && (j-i+1) > longest.length()) {
                    longest = s.substring(i, j+1);
                }
            }
        }
        return longest;
    }

    public boolean isPalindrome(String s, int from, int to, int[][] memo) {
        if(from == to) {
            memo[from][to] = 1;
            return true;
        }
        if((from + 1) == to) {
            memo[from][to] = s.charAt(from) == s.charAt(to) ? 1 : 0;
            return memo[from][to] == 1;
        }
        else {
            if(memo[from][to] != -1) {
                return memo[from][to] == 1;
            }
            else {
                memo[from][to] = ((s.charAt(from) == s.charAt(to)) && isPalindrome(s, from+1, to-1, memo)) ? 1 : 0;
                return memo[from][to] == 1;
            }
        }
    }

    public void run() {
        String s = "babadab";
        System.out.println(getLongestPalindrome(s));
    }
    public static void main(String[] args) {
        new LongestPalindromicSubstring().run();
    }
}