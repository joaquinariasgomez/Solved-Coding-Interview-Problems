import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minSubstringBRUTEFORCE(String s, String t) {  //O(n^3)
        HashMap<Character, Integer> needMap = new HashMap<Character, Integer>();
        int minLengthString = Integer.MAX_VALUE;
        String sol = "";
        for(char st:t.toCharArray()) needMap.put(st, needMap.getOrDefault(st, 0)+1);

        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                // Does the word from i to j contain the letters that are stored in the map, with the same exact count?
                HashMap<Character, Integer> haveMap = new HashMap<Character, Integer>();
                for(int a=i; a<=j; a++) {   // Window iterator
                    haveMap.put(s.charAt(a), haveMap.getOrDefault(s.charAt(a), 0)+1);
                }
                boolean satifyOurNeed = true;
                for(HashMap.Entry<Character, Integer> entry : needMap.entrySet()) {
                    char character = entry.getKey();
                    if(haveMap.get(character) == null || haveMap.get(character) < entry.getValue()) {
                        satifyOurNeed = false;
                    }
                }
                if(satifyOurNeed) {
                    String candidate = s.substring(i, j+1);
                    if(candidate.length() < minLengthString) {
                        sol = candidate;
                        minLengthString = candidate.length();
                    }
                }
            }
        }
        return sol;
    }

    public String minSubstring(String s, String t) {    // O(n) time, O(n) space
        HashMap<Character, Integer> needMap = new HashMap<Character, Integer>();
        for(char ct : t.toCharArray()) needMap.put(ct, needMap.getOrDefault(ct, 0)+1);
        
        int begin = 0;
        int bestBegin = 0;
        int matchedChars = 0;
        int minLengthString = Integer.MAX_VALUE;
        String sol = "";
        for(int end=0; end<s.length(); end++) {
            char endChar = s.charAt(end);
            if(needMap.containsKey(endChar)) {
                needMap.put(endChar, needMap.get(endChar)-1);
                if(needMap.get(endChar) == 0) matchedChars++;
            }
            while(matchedChars == needMap.size()) {
                if(end-begin+1 < minLengthString) {
                    minLengthString = end-begin+1;
                    bestBegin = begin;
                    sol = s.substring(bestBegin, bestBegin + minLengthString);
                }
                char deletedChar = s.charAt(begin++);
                if(needMap.containsKey(deletedChar)) {
                    if(needMap.get(deletedChar) == 0) matchedChars--;
                    needMap.put(deletedChar, needMap.get(deletedChar)+1);
                }
            }
        } 

        return sol;
    }

    public void run() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minSubstring(s, t));
    }
    public static void main(String[] args) {
        new MinimumWindowSubstring().run();
    }
}