import java.util.*;

class IsomorphicStrings {
    private String transformString(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        StringBuilder sol = new StringBuilder();
        for(int i=0; i<input.length(); i++) {
            if(map.containsKey(input.charAt(i))) {
                sol.append(map.get(input.charAt(i))+" ");
            }
            else {
                map.put(input.charAt(i), i);
                sol.append(i+" ");
            }
        }
        return sol.toString();
    }
    
    public boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }

    public void run() {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }
    public static void main(String[] args) {
        new IsomorphicStrings().run();
    }
}
