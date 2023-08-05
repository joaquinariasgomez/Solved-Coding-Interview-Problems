import java.util.HashMap;

public class Anagram {

    public boolean areAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char d : str2.toCharArray()) {
            map.put(d, map.getOrDefault(d, 0)-1);
        }
        for(HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0) return false;
        }
        return true;
    }

    public void run() {
        String str1 = "cinema";
        String str2 = "iceman";
        System.out.println(areAnagram(str1, str2));
    }
    public static void main(String[] args) {
        new Anagram().run();
    }
}