public class Palindrome3 {

    public boolean isAlphabeticalCharacter(char a) {
        // for(char c='a'; c<='z'; c++) {
        //     if(a==c) return true;
        // }
        // return false;
        return Character.isLetter(a);
    }

    public boolean isPalindrome(String text) {
        char[] array = text.toCharArray();

        int begin = 0;
        int end = array.length-1;
        while(begin < end) {
            char charBegin = Character.toLowerCase(array[begin]);
            char charEnd = Character.toLowerCase(array[end]);
            if(!isAlphabeticalCharacter(charBegin)) {
                begin++;
            }
            if(!isAlphabeticalCharacter(charEnd)) {
                end--;
            }
            if(charBegin != charEnd) {
                if(isAlphabeticalCharacter(charBegin) && isAlphabeticalCharacter(charEnd)) {
                    return false;
                }
            }
            else {
                begin++;
                end--;
            }
        }
        return true;
    }

    public void run() {
        String text = "A man, a plan, a canal: Panama.";
        System.out.println(isPalindrome(text));
    }
    public static void main(String[] args) {
        new Palindrome3().run();
    }
}
