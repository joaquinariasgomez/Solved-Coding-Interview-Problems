import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int getLongest(String input) {
        int longest = 0;
        int begin = 0;
        int end = 0;
        HashSet<Character> seen = new HashSet<Character>();
        while(end < input.length()) {
            if(seen.contains(input.charAt(end))) {
                seen.remove(input.charAt(begin++));
            }
            else {
                seen.add(input.charAt(end++));
                longest = Math.max(longest, seen.size());
            }
        }
        return longest;
    }

    public void run() {
        String input = "abcabcbb";
        System.out.println(getLongest(input));
    }
    public static void main(String[] args) {
        new LongestSubstringWithoutRepeatingCharacters().run();
    }
}