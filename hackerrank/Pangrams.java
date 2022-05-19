import java.util.HashSet;

public class Pangrams {

    public String isPangram(String s) {
        HashSet<Character> possibleChars = new HashSet<Character>();
        for(char c='a'; c<='z'; c++) {
            possibleChars.add(c);
        }
        for(int i=0; i<s.length(); i++) {
            if(possibleChars.contains(Character.toLowerCase(s.charAt(i)))) {
                possibleChars.remove(Character.toLowerCase(s.charAt(i)));
            }
        }
        
        if(possibleChars.size() == 0) {
            return "pangram";
        }
        else {
            return "not pangram";
        }
    }

    public void run() {
        String test = "widohqwoidhqwdo";
        System.out.println(isPangram(test));
    }
    public static void main(String[] args) {
        new Pangrams().run();
    }
}
