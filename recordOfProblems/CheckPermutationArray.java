public class CheckPermutationArray {

    public boolean checkPermutation(String string1, String string2) {
        if(string1.length() != string2.length()) return false;

        int[] count = new int[128]; // We are gonna assume that we are using ASCII and that we have 128 letters. Also, that we do not have spaces, nor uppercase chars
        for(int i=0; i<string1.length(); i++) {
            count[string1.charAt(i)]++;
        }

        for(int i=0; i<string2.length(); i++) {
            count[string2.charAt(i)]--;
            if(count[string2.charAt(i)] < 0) return false;
        }
        return true;
    }

    public void run() {
        String string1="acab";
        String string2="aacb";
        System.out.println(checkPermutation(string1, string2));
    }
    public static void main(String[] args) {
        new CheckPermutationArray().run();
    }
}