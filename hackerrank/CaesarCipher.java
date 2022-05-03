public class CaesarCipher {

    public String caesarCipher(String s, int k) {
        // Write your code here
        char[] input = s.toCharArray();
        
        for(int i =0; i<input.length; i++) {
            char character = input[i];
            boolean upperCase = Character.isUpperCase(character);
            if(Character.isLetter(character)) {
                character += k%26;
                if(!Character.isLetter(character) || (upperCase && !Character.isUpperCase(character))) character -= 26;
                input[i] = character;
            }
        }
        
        return String.valueOf(input);
    }

    public void run() {
        String input = "abcde";
        System.out.println(caesarCipher(input, 3));
    }
    public static void main(String[] args) {
        new CaesarCipher().run();
    }
}
