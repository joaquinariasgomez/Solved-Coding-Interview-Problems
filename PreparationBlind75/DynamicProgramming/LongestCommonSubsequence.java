public class LongestCommonSubsequence {

    public int longestCommon(String text1, String text2) {
        int[][] memo = new int[text1.length()+1][text2.length()+1];
        if(text2.length() == 0 || text1.length() == 0) return 0;

        for(int i=text1.length()-1; i>=0; i--) {
            for(int j=text2.length()-1; j>=0; j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    memo[i][j] = 1 + memo[i+1][j+1];
                }
                else {
                    memo[i][j] = Math.max(memo[i+1][j], memo[i][j+1]);
                }
            }
        }
        return memo[0][0];
    }

    public void run() {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommon(text1, text2));
    }
    public static void main(String[] args) {
        new LongestCommonSubsequence().run();
    }
}