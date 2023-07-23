import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.print.attribute.HashAttributeSet;

public class GroupAnagrams {

    public boolean areAnagrams(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] letters = new int[256];   // Number of extended ASCII chars
        
        for(int i=0; i<s.length(); i++) {
            letters[s.charAt(i)]++;
        }
        for(int i=0; i<t.length(); i++) {
            letters[t.charAt(i)]--;
        }
        for(int i=0; i<letters.length; i++) {
            if(letters[i] != 0) return false;
        }

        return true;
    }

    public List<List<String>> getGroupedAnagsSLOW(String[] anagrams) {   // Slow means that it is O(k * nlogn) -> k is number of anagrams and n is average length of anagram
        List<List<String>> sol = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String anagr : anagrams) {
            char[] anagr_arr = anagr.toCharArray();
            Arrays.sort(anagr_arr);
            if(map.containsKey(new String(anagr_arr))) {
                ArrayList<String> currentList = map.get(new String(anagr_arr));
                currentList.add(anagr);
                map.put(new String(anagr_arr), currentList);
            }
            else {
                ArrayList<String> newAnagrList = new ArrayList<String>();
                newAnagrList.add(anagr);
                map.put(new String(anagr_arr), newAnagrList);
            }
        }

        int idx = 0;
        for(HashMap.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            List<String> values = entry.getValue();
            sol.add(idx++, values);
        }

        return sol;
    }

    private String createHash(String word) {    // "eat" -> "10000100010...."
        int[] count = new int[26];
        for(int j=0; j<word.length(); j++) {
            count[(int)word.charAt(j) - (int)('a')]++;
        }
        return Arrays.toString(count);
    }

    public List<List<String>> getGroupedAnagsFAST(String[] anagrams) {
        List<List<String>> sol = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String anagr : anagrams) {
            String anagrHash = createHash(anagr);
            if(map.containsKey(anagrHash)) {
                ArrayList<String> currentList = map.get(anagrHash);
                currentList.add(anagr);
                map.put(anagrHash, currentList);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(anagr);
                map.put(anagrHash, list);
            }
        }

        int idx = 0;
        for(HashMap.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            List<String> values = entry.getValue();
            sol.add(idx++, values);
        }

        return sol;
    }

    public void run() {
        String[] anagrams = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> sol = getGroupedAnagsFAST(anagrams);

        for(int i=0; i<sol.size(); i++) {
            List<String> item = sol.get(i);
            for(int j=0; j<item.size(); j++) {
                System.out.print(item.get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new GroupAnagrams().run();
    }
}