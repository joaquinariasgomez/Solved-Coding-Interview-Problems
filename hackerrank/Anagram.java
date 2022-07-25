import java.util.HashMap;

public class Anagram {

    public int howManyChangesToAnagram(String s) {
        if(s.length()%2!=0) return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length()/2; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        int counter = 0;
        for(int i=s.length()/2; i<s.length(); i++) {
            if(map.get(s.charAt(i)) != null) {
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
            }
            else {
                counter++;
            }
        }
        for(HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() < 0) {
                counter -= entry.getValue();
            }
        }
        return counter;
    }

    public void run() {
        String test = "abccaceb";
        System.out.println(howManyChangesToAnagram(test));
    }
    public static void main(String[] args) {
        new Anagram().run();
    }
}
