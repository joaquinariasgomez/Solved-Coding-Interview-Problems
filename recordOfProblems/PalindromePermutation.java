import java.util.HashSet;

public class PalindromePermutation {

    public boolean isPalindromePerm(String input) {
        HashSet<Character> set = new HashSet<Character>();

        for(int i=0; i<input.length(); i++) {
            Character currentChar = input.charAt(i);
            if(currentChar != ' ') {
                currentChar = Character.toLowerCase(currentChar);
                if(set.contains(currentChar)) {
                    set.remove(currentChar);
                }
                else {
                    set.add(currentChar);
                }
            }
        }
        return set.size() == 0 || set.size() == 1;
    }

    public void run() {
        String input = "Tact coa";
        System.out.println(isPalindromePerm(input));
    }
    public static void main(String[] args) {
        new PalindromePermutation().run();
    }
}