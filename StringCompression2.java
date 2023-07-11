public class StringCompression2 {

    public String compression(String input) {
        StringBuilder sol = new StringBuilder();
        int count = 1;

        for(int i=0; i<input.length() - 1; i++) {
            if(input.charAt(i) == input.charAt(i+1)) {
                count++;
            }
            else {
                sol.append(input.charAt(i)+Integer.toString(count));
                count = 1;
            }
        }
        sol.append(input.charAt(input.length()-1)+Integer.toString(count));
        String result = sol.toString(); 
        return (input.length() < result.length()) ? input : result;
    }

    public void run() {
        String input = "aabcccccaaa";
        System.out.println(compression(input));
    }
    public static void main(String[] args) {
        new StringCompression2().run();
    }
}