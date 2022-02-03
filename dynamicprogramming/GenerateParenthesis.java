import java.util.ArrayList;
import java.util.HashSet;

public class GenerateParenthesis {

    public void addInsideParenthesis(HashSet<String> parenthesis, String prevParenthesis) {
        for(int i=0; i<prevParenthesis.length(); i++) {
            if(prevParenthesis.charAt(i) == '(') {
                String start = prevParenthesis.substring(0, i+1);
                String end = prevParenthesis.substring(i+1);
                parenthesis.add(start+"()"+end);
            }
        }
    }

    public HashSet<String> generate(int n) {
        HashSet<String> parenthesis = new HashSet<String>();
        if(n==0) return parenthesis;
        if(n==1) {
            parenthesis.add("()");
        }
        else {
            HashSet<String> currentParenthesis = generate(n-1);
            for(String prevParenthesis : currentParenthesis) {
                // Add parenthesis at the beginning
                parenthesis.add("()"+prevParenthesis);
                // Add parenthesis after every '('. Trick we should see "n-1" open parenthesis
                addInsideParenthesis(parenthesis, prevParenthesis);
            }
        }
        return parenthesis;
    }

    public void run() {
        int n = 3;
        ArrayList<String> parenthesis = new ArrayList<String>(generate(n));
        for(String par: parenthesis) {
            System.out.println(par);
        }
    }
    public static void main(String[] args) {
        new GenerateParenthesis().run();
    }
}
