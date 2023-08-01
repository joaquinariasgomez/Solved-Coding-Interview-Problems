import java.util.*;

public class EncodeAndDecodeStrings {

    public String encode(List<String> strs) {
        StringBuilder sol = new StringBuilder();
        for(String str : strs) {
            sol.append(str.length());
            sol.append('#');
            sol.append(str);
        }
        return sol.toString();
    }

    public List<String> decode(String str) {
        List<String> sol = new ArrayList<String>();
        
        int it = 0;
        while(it < str.length()) {
            int j=it;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(it, j));
            sol.add(str.substring(j+1, j+1+length));
            it = j+1+length;
        }
        return sol;
    }

    public void run() {
        List<String> strs = new ArrayList<>();
        strs.add("4#neet");
        strs.add("code");
        System.out.println(encode(strs));
        strs = decode(encode(strs));
        for(String str : strs) {
            System.out.println(str);
        }
    }
    public static void main(String[] args) {
        new EncodeAndDecodeStrings().run();
    }
}