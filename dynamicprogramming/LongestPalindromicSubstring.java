public class LongestPalindromicSubstring {

    public String getLongest(String input) {
        if(input.length()==0) return "";
        int length = input.length();
        boolean[][] memoization = new boolean[length][length];
        String bestResult = "";
        int maxLength = 0;

        for(int i=length-1; i>=0; i--) {
            for(int j=i; j<length; j++) {
                if(i==j) {
                    memoization[i][j] = true;
                }
                else {
                    if(i==(j-1)) {
                        memoization[i][j] = (input.charAt(i) == input.charAt(j));
                    }
                    else {
                        memoization[i][j] = (input.charAt(i) == input.charAt(j) ? memoization[i+1][j-1] : false); 
                    }
                }
                if(memoization[i][j]) {
                    if(j-i+1 > maxLength) {
                        maxLength = j-i+1;
                        bestResult = input.substring(i, j+1);
                    }
                }
            }
        }

        return bestResult;
    }

    public void run() {
        String test = "babaa";
        System.out.println(getLongest(test));
    }
    public static void main(String[] args) {
        new LongestPalindromicSubstring().run();
    }
}