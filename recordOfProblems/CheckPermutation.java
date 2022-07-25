import java.util.HashMap;

public class CheckPermutation {

    public boolean checkCharacterCounts(String string1, String string2) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if(string1.length() != string2.length()) return false;

        char[] array1 = string1.toCharArray();
        char[] array2 = string2.toCharArray();
        for(int i=0; i<array1.length; i++) {
            map.put(array1[i], map.getOrDefault(array1[i], 0)+1);
        }
        for(int i=0; i<array2.length; i++) {
            map.put(array2[i], map.getOrDefault(array2[i], 0)-1);
            if(map.get(array2[i])<0) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        String string1 = "abcba";
        String string2 = "aabc";
        System.out.println(checkCharacterCounts(string1, string2));
    }

    public static void main(String[] args) {
        new CheckPermutation().run();
    }
}
