import java.util.Arrays;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] map = new int[26];    // char, count
        int[] seen = new int[26];
        
        for(int i=0; i<s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
        }
        
        int begin = 0;
        int end = 0;
        while(end < s2.length()) {
            if(map[s2.charAt(end)-'a'] > 0 && seen[s2.charAt(end)-'a'] < map[s2.charAt(end)-'a']) {
                seen[s2.charAt(end)-'a']++;
                end++;
                if (Arrays.equals(map, seen)) return true;
            }
            else {
                if(seen[s2.charAt(begin)-'a']>0) {
                    seen[s2.charAt(begin)-'a']--;
                }
                else {
                    seen[s2.charAt(begin)-'a'] = 0;
                }
                begin++;
                if(begin > end) end = begin;
            }
        }
        return false;
    }

    public void run() {
        String s1 = "ab";
        String s2 = "wddqbada";
        System.out.println(checkInclusion(s1, s2));
    }
    public static void main(String[] args) {
        new PermutationInString().run();
    }
}
