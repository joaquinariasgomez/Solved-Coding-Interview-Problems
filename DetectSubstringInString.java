public class DetectSubstringInString {

    public int getIndexSlow(String str, String obj) {   // O(n * m) && O(1) memory
        for(int i = 0; i<=(str.length()-obj.length()); i++) {
            String possibleSol = str.substring(i, i+obj.length());
            if(obj.equals(possibleSol)) return i;
        }
        return -1;
    }

    public int getIndexFast(String str, String obj) {
        return -1;
    }

    public void run() {
        String str = "home is where your cat is";
        String obj = "cat";
        // Return the index of the first ocurrence of "obj" in "str", or -1 if it doesn't occur.
        System.out.println(getIndexSlow(str, obj));
    }
    public static void main(String[] args) {
        new DetectSubstringInString().run();
    }
}