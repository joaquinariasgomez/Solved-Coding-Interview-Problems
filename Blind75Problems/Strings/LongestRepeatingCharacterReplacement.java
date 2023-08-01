import java.util.*;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        char[] count = new char[26];
        int begin = 0;
        int maxF = 0;
        int sol = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
            maxF = Math.max(maxF, count[s.charAt(i) - 'A']);

            while((i - begin + 1) - maxF > k) {
                count[s.charAt(begin) - 'A']--;
                begin++;
            }
            sol = Math.max(sol, i - begin + 1);
        }
        return sol;
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