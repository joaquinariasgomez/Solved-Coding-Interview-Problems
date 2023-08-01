public class ValidAnagram {

    public boolean areAnagrams(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] map = new int[256];

        for(char c : s.toCharArray()) {
            map[c]++;
        }

        for(char c : t.toCharArray()) {
            map[c]--;
        }

        for(int i=0; i<256; i++) {
            if(map[i] != 0) return false;
        }
        return true;
    }

    public void run() {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(areAnagrams(s, t));
    }
    public static void main(String[] args) {
        new ValidAnagram().run();
    }
}