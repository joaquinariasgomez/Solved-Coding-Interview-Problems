import java.util.*;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int begin = 0;
        int longest = 0;
        char[] map = new char[26];
        for(int end=0; end<s.length(); end++) { // O(26 * N) -> O(N)
            // We are currently at subarray begin - end
            map[s.charAt(end)-'A']++;
            int mostFreqChar = 0;
            for(int i=0; i<26; i++) {
                mostFreqChar = Math.max(mostFreqChar, map[i]);
            }
            int windowLength = end-begin+1;
            if(windowLength - mostFreqChar <= k) {
                longest = Math.max(longest, windowLength);
            }
            else {
                map[s.charAt(begin)-'A']--;
                begin++;
            }
        }
        return longest;
    }

    public void run() {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static void main(String[] args) {
        new LongestRepeatingCharacterReplacement().run();
    }
}