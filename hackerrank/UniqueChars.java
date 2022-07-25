public class UniqueChars {
    boolean isUniqueChars(String str) {
        if(str.length() > 128) return false;    // ASCII -> length of 128. Extended ASCII -> length of 256

        boolean[] char_set = new boolean[128];
        for(int i=0; i<str.length(); i++) {
            int val = str.charAt(i);
            if(char_set[val]) { // Already found this char in the string
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}
