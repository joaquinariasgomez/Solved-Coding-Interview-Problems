public class StringCompression {

    public String getStringCompressed(String input) {
        StringBuilder result = new StringBuilder();
        int consecutiveChars = 0;

        for(int i=0; i<input.length(); i++) {
           consecutiveChars++;
           
           if(i+1 >= input.length() || input.charAt(i) != input.charAt(i+1)) {
               result.append(input.charAt(i));
               result.append(consecutiveChars);
               consecutiveChars = 0;
           }
        }
        return result.length() > input.length() ? input : result.toString();
    }

    public void run() {
        String input = "aabcccccaaa";   //a2b1c5a3
        String result = getStringCompressed(input);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new StringCompression().run();
    }
}