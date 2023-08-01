public class PalindromicSubstrings {

    public int palindromicSubs(String s) {
        int sol = 0;
        int[][] memo = new int[s.length()][s.length()];
        for(int i=0; i<memo.length; i++)
            for(int j=0; j<memo[0].length; j++)
                memo[i][j] = -1;
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                if(isPalindrome(s, i, j, memo)) {
                    sol++;
                }
            }
        }
        return sol;
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
            if(memo[from][to] != -1) return memo[from][to] == 1;
            else {
                memo[from][to] = (s.charAt(from) == s.charAt(to) && isPalindrome(s, from+1, to-1, memo)) ? 1 : 0;
                return memo[from][to] == 1;
            }
        }
    }

    public void run() {
        String s = "aaa";
        // String s = "abc";
        System.out.println(palindromicSubs(s));
    }
    public static void main(String[] args) {
        new PalindromicSubstrings().run();
    }
}