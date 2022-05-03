public class PalindromeIndex {
    public int getIndex(String s) {
        int begin = 0;
        int end = s.length()-1;
        
        while(begin<=end) {
            if(s.charAt(begin) != s.charAt(end)) {
                if(s.charAt(begin+1) == s.charAt(end)) {
                    return begin;
                }
                else {
                    if(s.charAt(end-1) == s.charAt(begin)) {
                        return end;
                    }
                    else {
                        begin++;
                        end--;
                    }
                }
            }
            else {
                begin++;
                end--;
            }
        }
        
        return -1;
    }

    public void run() {
        String s = "abcctba";
        System.out.println(getIndex(s));
    }
    public static void main(String[] args) {
        new PalindromeIndex().run();
    }
}
