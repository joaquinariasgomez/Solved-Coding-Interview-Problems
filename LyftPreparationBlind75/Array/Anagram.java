public class Anagram {

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
    
    public void run() {
        String a = "helloe";
        String b = "lehloe";
        System.out.println(areAnagrams(a, b));
    }
    public static void main(String[] args) {
        new Anagram().run();
    }
}