public class DecodeWays {

    public int decodeWays(String input) {
        int[] memo = new int[input.length()];
        for(int i=0; i<memo.length; i++) memo[i] = -1;
        return decodeWaysRec(input, 0, memo);
    }

    public int decodeWaysRec(String input, int currPos, int[] memo) {
        // System.out.println("Input: "+input+" pos: "+currPos);
        if(currPos > input.length()) return 0;
        if(currPos == input.length()) return 1;
        if(memo[currPos] != -1) return memo[currPos];
        if(input.substring(currPos, currPos+1).equals("0")) {memo[currPos] = 0; return memo[currPos];}
        if((input.length() - currPos) == 1) {   // Just one character to count
            memo[currPos] = decodeWaysRec(input, currPos+1, memo);
            return memo[currPos];
        }
        else {  // Two or more characters to count
            int waysPickingOne = decodeWaysRec(input, currPos+1, memo);
            int waysPickingTwo = (Integer.parseInt(input.substring(currPos, currPos+2)) <= 26) ? decodeWaysRec(input, currPos+2, memo) : 0;
            memo[currPos] = waysPickingOne + waysPickingTwo;
            return memo[currPos];
        }
    }

    public void run() {
        String input = "226";
        System.out.println(decodeWays(input));
    }
    public static void main(String[] args) {
        new DecodeWays().run();
    }
}