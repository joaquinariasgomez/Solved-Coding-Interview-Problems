public class Anagrams {

    public boolean areAnagrams(String a, String b) {
        char[] freq = new char[400];    //Puede ser menor que 400 seguramente, probar con 270 o algo así
        for(int i=0; i<freq.length; i++) freq[i] = 0;
        
        for(Character c : a.toCharArray()) {
            freq[Character.toLowerCase(c)]++;
        }
        for(Character c : b.toCharArray()) {
            freq[Character.toLowerCase(c)]--;
        }
        for(int i=0; i<freq.length; i++) {
            if(freq[i]!=0) return false;
        }
        return true;
    }

    public void run() {
        String a = "anagram";
        String b = "margana";
        System.out.println(areAnagrams(a, b));
    }
    public static void main(String[] args) {
        new Anagrams().run();
    }
}
