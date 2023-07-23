import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public boolean wordbreak(List<String> dict, String s) {
        boolean[] memo = new boolean[s.length()+1];
        memo[s.length()] = true;

        for(int i=s.length()-1; i>=0; i--) {
            // For every position in the string s, we want to try every word in the dictionary
            for(int j=0; j<dict.size(); j++) {
                if(i+dict.get(j).length() <= s.length()) {
                    String subS = s.substring(i, i+dict.get(j).length());
                    if(subS.equals(dict.get(j))) {
                        memo[i] = memo[i + dict.get(j).length()];
                    }
                    if(memo[i]) break;
                }
            }
        }
        return memo[0];
    }

    public void run() {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("apple");
        wordDict.add("pen");
        // String s = "neetcode";
        // String[] wordDict = {"neet", "leet", "code"};
        System.out.println(wordbreak(wordDict, s));
    }

    public static void main(String[] args) {
        new WordBreak().run();
    }
}